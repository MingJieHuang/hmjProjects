package com.phone.erp.websocket.controller;

import com.phone.erp.base.Constants;
import com.phone.erp.base.utils.Assert;
import com.phone.erp.websocket.common.WebsocketConstants;
import com.phone.erp.websocket.enums.Action;
import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.service.RetailService;
import com.phone.erp.websocket.service.WebSocketSessionRegistryService;
import com.phone.erp.websocket.vo.MessageVo;
import com.phone.erp.websocket.vo.SendMessageResult;
import com.phone.erp.websocket.vo.WebSocketUser;
import com.phone.erp.websocket.vo.retail.ParamMessageVo;
import com.phone.erp.websocket.vo.retail.PrintParamVo;
import com.phone.erp.websocket.vo.retail.RetailOrderVo;
import org.apache.commons.lang3.StringUtils;
import org.chrisli.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * [websocket控制器]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Controller
@RequestMapping("${project.url.prefix}")
public class WebSocketController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebSocketSessionRegistryService webSocketSessionRegistryService;

    @Autowired
    private RetailService retailService;

    /**
     * [接收客户端发送的WebSocket请求]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @MessageMapping("/message/handler")
    public void handler(@Headers Map<String, Object> headers, String message) {
        WebSocketUser webSocketUser = (WebSocketUser) headers.get("simpUser");
        logger.info(String.format("收到来自客户端%s发送的消息[%s].", webSocketUser.getName(), message));
        MessageVo messageVo = JsonUtil.jsonToBean(message, MessageVo.class);
        SendMessageResult sendedResult = webSocketSessionRegistryService.handlerClientMessage(webSocketUser, messageVo);
        logger.info("客户端消息处理结果:" + sendedResult);
    }

    /**
     * [店员助手小程序零售单据云打印]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @SuppressWarnings("unchecked")
    @RequestMapping("/clerk/assistant/retail/print")
    @ResponseBody
    public Map<String, Object> print(Long billsId) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("data", new HashMap<String, Object>());
        returnMap.put("result", 1);
        Assert.notNull(billsId, "打印的单据id不允许为空!");
        RetailOrderVo orderVo = retailService.getRetailOrderVoById(billsId);
        Assert.notNull(orderVo, "未查到匹配的零售单!");
        logger.info(String.format("零售出库单[%s][%d]云打印请求发送中...", orderVo.getBillsCode(), billsId));
        // 获取本零售单门店对应的云打印电脑和打印参数等信息
        PrintParamVo printParamVo = retailService.getPrintParamVoByBillsId(billsId);
        if (printParamVo == null) {
            logger.info(String.format("零售出库单[%d]不存在.", billsId));
            ((Map<String, Object>) returnMap.get("data")).put("message", "未找到匹配的单据,无法打印!");
            ((Map<String, Object>) returnMap.get("data")).put("success", false);
            return returnMap;
        } else if (StringUtils.isBlank(printParamVo.getComputerCode()) || WebsocketConstants.ABERRANT_COMPUTER_ID.equals(printParamVo.getComputerCode())) {
            // 未获取到电脑id或者获取到非法的电脑id
            logger.info(String.format("零售出库单[%s][%d]所在门店未配置云打印参数.", orderVo.getBillsCode(), billsId));
            ((Map<String, Object>) returnMap.get("data")).put("message", "本店未配置\"我的电脑\",单据无法打印!");
            ((Map<String, Object>) returnMap.get("data")).put("success", false);
            return returnMap;
        } else if (printParamVo.getStatus().intValue() == 1) {
            logger.info(String.format("零售出库单[%s][%d]所在门店已配置云打印参数,但非启用状态.", orderVo.getBillsCode(), billsId));
            ((Map<String, Object>) returnMap.get("data")).put("message", "本店配置的\"我的电脑\"未启用,单据无法打印!");
            ((Map<String, Object>) returnMap.get("data")).put("success", false);
            return returnMap;
        }
        // 推送云打印请求
        WebSocketUser webSocketUser = new WebSocketUser(Constants.WS_SYSTEM_ADMIN_NAME, Client.ERP, Constants.WS_SYSTEM_ADMIN_ID);
        MessageVo messageVo = new MessageVo(Action.PRINT_RETAIL_ORDER.getCode(), JsonUtil.beanToJson(new ParamMessageVo(printParamVo
                .getComputerCode(), billsId, orderVo.getUnionPayAmount() > 0 ? 1 : 0)));
        SendMessageResult sendedResult = webSocketSessionRegistryService.handlerClientMessage(webSocketUser, messageVo);
        if (sendedResult.hasSended()) {
            logger.info(String.format("零售出库单[%s][%d]云打印请求发送成功,发送的消息数[%d].", orderVo.getBillsCode(), billsId, sendedResult.getSendedCount()));
            ((Map<String, Object>) returnMap.get("data")).put("message", "单据及收款凭据正在打印中,请领取!");
        } else if (StringUtils.isEmpty(sendedResult.getErrorMsg())) {
            logger.info(String.format("零售出库单[%s][%d]云打印请求发送失败,没有员工使用配置的打印电脑在ERP系统的WEB平台上登录.", orderVo.getBillsCode(), billsId));
            ((Map<String, Object>) returnMap.get("data")).put("message", "本店配置的\"我的电脑\"上没有员工登录ERP系统,单据无法打印!");
        } else {
            logger.info(String.format("零售出库单[%s][%d]云打印请求发送中出现异常.", orderVo.getBillsCode(), billsId));
            ((Map<String, Object>) returnMap.get("data")).put("message", "云打印请求发送中出现异常,请联系系统管理员!");
        }
        ((Map<String, Object>) returnMap.get("data")).put("success", sendedResult.hasSended());
        return returnMap;
    }
}