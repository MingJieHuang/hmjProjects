package com.phone.erp.websocket.service.impl;

import com.phone.erp.base.Constants;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.base.vo.employee.EmployeeVo;
import com.phone.erp.websocket.common.WebsocketConstants;
import com.phone.erp.websocket.enums.Action;
import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.service.LoginService;
import com.phone.erp.websocket.service.WebSocketSessionRegistryService;
import com.phone.erp.websocket.vo.MessageVo;
import com.phone.erp.websocket.vo.OnlineUserVo;
import com.phone.erp.websocket.vo.SendMessageResult;
import com.phone.erp.websocket.vo.WebSocketUser;
import com.phone.erp.websocket.vo.retail.ParamMessageVo;
import org.apache.commons.collections4.CollectionUtils;
import org.chrisli.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * [WebSocket Session注册服务实现类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Service
public class WebSocketSessionRegistryServiceImp implements WebSocketSessionRegistryService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private LoginService loginService;

    /**
     * [存储在线用户信息]
     */
    private ConcurrentMap<String, Set<OnlineUserVo>> onlineUserMap = new ConcurrentHashMap<String, Set<OnlineUserVo>>();

    @Override
    public void registerWebSocketUser(WebSocketUser webSocketUser) {
        try {
            String onlineUserKey = String.format("[%s-%s]", webSocketUser.getClient().getCode(), webSocketUser.getUserId());
            synchronized (WebSocketUser.class) {
                Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(onlineUserKey);
                if (CollectionUtils.isEmpty(onlineUserSet)) {
                    onlineUserSet = new HashSet<OnlineUserVo>();
                }
                onlineUserSet.add(new OnlineUserVo(webSocketUser.getName()));
                logger.info(String.format("向在线用户集合中添加%s...", webSocketUser.getName()));
                onlineUserMap.put(onlineUserKey, onlineUserSet);
                loginService.saveLoginStatus(webSocketUser, 0);
                // 强制下线之前的连接,保证一个账号只允许在一个浏览器登录
                forceOffLinePreviousLogin(webSocketUser, onlineUserSet);
            }
        } catch (Exception e) {
            logger.error("注册websocket用户" + webSocketUser + "时出现异常", e);
        }
    }

    /**
     * [强制下线之前的连接,保证一个账号只允许在一个浏览器登录]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    private void forceOffLinePreviousLogin(WebSocketUser webSocketUser, Set<OnlineUserVo> onlineUserSet) {
        for (OnlineUserVo onlineUserVo : onlineUserSet) {
            if (!webSocketUser.getName().equals(onlineUserVo.getClientName())) {
                logger.info(String.format("向%s客户端发送重复登录下线指令...", onlineUserVo.getClientName()));
                simpMessagingTemplate.convertAndSendToUser(onlineUserVo.getClientName(), Constants.WS_MSG_TO_USER_QUEUE_NAME, JsonUtil
                        .beanToJson(new MessageVo(Action.REPEAT_KICK_OUT.getCode())));
            }
        }
    }

    @Override
    public void removeWebSocketUser(WebSocketUser webSocketUser) {
        try {
            String onlineUserKey = String.format("[%s-%s]", webSocketUser.getClient().getCode(), webSocketUser.getUserId());
            synchronized (WebSocketUser.class) {
                Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(onlineUserKey);
                if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                    // 用户信息存在,移除当前用户信息
                    for (Iterator<OnlineUserVo> iterator = onlineUserSet.iterator(); iterator.hasNext(); ) {
                        OnlineUserVo onlineUserVo = iterator.next();
                        if (webSocketUser.getName().equals(onlineUserVo.getClientName())) {
                            logger.info(String.format("从在线用户集合中移除%s...", onlineUserVo.getClientName()));
                            iterator.remove();
                            loginService.saveLoginStatus(webSocketUser, 1);
                        }
                    }
                    // 移除后,如果该用户信息集合已不存在,则移除key
                    if (CollectionUtils.isEmpty(onlineUserSet)) {
                        onlineUserMap.remove(onlineUserKey);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("移除websocket用户" + webSocketUser + "时出现异常", e);
        }
    }

    @Override
    public SendMessageResult handlerClientMessage(WebSocketUser webSocketUser, MessageVo messageVo) {
        SendMessageResult sendedResult = new SendMessageResult();
        try {
            if (messageVo.getCommand().equalsIgnoreCase(Action.FORCE_KICK_OUT.getCode())) {
                // 强制踢出指定用户
                Assert.notBlank(messageVo.getParam(), "{employeeId}参数不允许为空!");
                Assert.isLong(messageVo.getParam(), String.format("{employeeId}参数[%s]不合法,必须是Long!", messageVo.getParam()));
                // 获取匹配的在线用户
                String matchedUserKey = String.format("[%s-%s]", webSocketUser.getClient().getCode(), messageVo.getParam());
                synchronized (WebSocketUser.class) {
                    Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(matchedUserKey);
                    if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                        for (OnlineUserVo onlineUserVo : onlineUserSet) {
                            logger.info(String.format("向%s客户端发送强制下线指令...", onlineUserVo.getClientName()));
                            simpMessagingTemplate.convertAndSendToUser(onlineUserVo.getClientName(), Constants.WS_MSG_TO_USER_QUEUE_NAME, JsonUtil
                                    .beanToJson(new MessageVo(Action.FORCE_KICK_OUT.getCode())));
                            sendedResult.addSendedCount();
                        }
                    }
                }
            } else if (messageVo.getCommand().equalsIgnoreCase(Action.AUTH_KICK_OUT.getCode())) {
                // 踢出指定角色下所有在线用户
                Assert.notBlank(messageVo.getParam(), "{roleId}参数不允许为空!");
                Assert.isLong(messageVo.getParam(), String.format("{roleId}参数[%s]不合法,必须是Long!", messageVo.getParam()));
                // 获取本角色下的所有在线员工
                List<EmployeeVo> employeeVoList = loginService.getRoleOnLineEmployeeVoList(webSocketUser.getClient().getType(), Long
                        .valueOf(messageVo.getParam()));
                for (EmployeeVo employeeVo : employeeVoList) {
                    // 遍历每个在线员工,踢下线
                    String matchedUserKey = String.format("[%s-%s]", webSocketUser.getClient().getCode(), employeeVo.getId().toString());
                    synchronized (WebSocketUser.class) {
                        Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(matchedUserKey);
                        if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                            for (OnlineUserVo onlineUserVo : onlineUserSet) {
                                logger.info(String.format("向%s客户端发送重新授权下线指令...", onlineUserVo.getClientName()));
                                simpMessagingTemplate.convertAndSendToUser(onlineUserVo.getClientName(), Constants.WS_MSG_TO_USER_QUEUE_NAME,
                                        JsonUtil.beanToJson(new MessageVo(Action.AUTH_KICK_OUT.getCode())));
                                sendedResult.addSendedCount();
                            }
                        }
                    }
                }
            } else if (messageVo.getCommand().equalsIgnoreCase(Action.BIND_LOGIN_COMPUTER.getCode())) {
                // 绑定用户登录的电脑
                Assert.notBlank(messageVo.getParam(), "{computerCode}参数不允许为空!");
                Assert.isFalse(WebsocketConstants.ABERRANT_COMPUTER_ID.equals(messageVo.getParam()), String.format("电脑编号[%s]存在异常!", messageVo.getParam()));
                // 获取匹配的在线用户
                String matchedUserKey = String.format("[%s-%s]", webSocketUser.getClient().getCode(), webSocketUser.getUserId());
                synchronized (WebSocketUser.class) {
                    Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(matchedUserKey);
                    if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                        for (OnlineUserVo onlineUserVo : onlineUserSet) {
                            if (webSocketUser.getName().equals(onlineUserVo.getClientName())) {
                                logger.info(String.format("绑定%s客户端登录的电脑编号[%s]...", onlineUserVo.getClientName(), messageVo.getParam()));
                                onlineUserVo.setComputerCode(messageVo.getParam());
                            }
                        }
                    }
                }
            } else if (messageVo.getCommand().equalsIgnoreCase(Action.PRINT_RETAIL_ORDER.getCode())) {
                // 打印零售单
                Assert.notBlank(messageVo.getParam(), "[打印]参数不允许为空!");
                ParamMessageVo paramMessageVo = JsonUtil.jsonToBean(messageVo.getParam(), ParamMessageVo.class);
                Assert.notBlank(paramMessageVo.getComputerCode(), "[打印]参数中{computerCode}参数不允许为空!");
                // 遍历所有在线用户,检查其登录的电脑编号,如果匹配到需要打印的电脑编号,则给该用户发送打印零售单据消息
                synchronized (WebSocketUser.class) {
                    for (String userKey : onlineUserMap.keySet()) {
                        Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(userKey);
                        if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                            for (OnlineUserVo onlineUserVo : onlineUserSet) {
                                if (paramMessageVo.getComputerCode().equals(onlineUserVo.getComputerCode())) {
                                    logger.info(String.format("向登录的电脑编号[%s]的%s客户端发送打印零售单[%d]的请求...", onlineUserVo.getComputerCode(), onlineUserVo
                                            .getClientName(), paramMessageVo.getBillsId()));
                                    simpMessagingTemplate.convertAndSendToUser(onlineUserVo.getClientName(), Constants.WS_MSG_TO_USER_QUEUE_NAME,
                                            JsonUtil.beanToJson(new MessageVo(Action.PRINT_RETAIL_ORDER.getCode(), JsonUtil
                                                    .beanToJsonAll(paramMessageVo))));
                                    sendedResult.addSendedCount();
                                    return sendedResult;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("处理客户端消息出现异常!", e);
            sendedResult.setErrorMsg(e.getMessage());
        }
        return sendedResult;
    }

    @Override
    public SendMessageResult kickOutExpiredOnLineEmployee(Client client) {
        SendMessageResult sendedResult = new SendMessageResult();
        try {
            // 获取过期的在线用户集合
            List<EmployeeVo> employeeVoList = loginService.getExpiredOnLineEmployeeVoList(client.getType());
            for (EmployeeVo employeeVo : employeeVoList) {
                // 遍历每个过期的在线员工,踢下线
                String matchedUserKey = String.format("[%s-%s]", client.getCode(), employeeVo.getId().toString());
                synchronized (WebSocketUser.class) {
                    Set<OnlineUserVo> onlineUserSet = onlineUserMap.get(matchedUserKey);
                    if (CollectionUtils.isNotEmpty(onlineUserSet)) {
                        for (OnlineUserVo onlineUserVo : onlineUserSet) {
                            logger.info(String.format("向%s客户端发送账号已过期下线指令...", onlineUserVo.getClientName()));
                            simpMessagingTemplate.convertAndSendToUser(onlineUserVo.getClientName(), Constants.WS_MSG_TO_USER_QUEUE_NAME, JsonUtil
                                    .beanToJson(new MessageVo(Action.EXPIRED_KICK_OUT.getCode())));
                            sendedResult.addSendedCount();
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("系统自动踢出过期用户中出现异常!", e);
            sendedResult.setErrorMsg(e.getMessage());
        }
        return sendedResult;
    }
}
