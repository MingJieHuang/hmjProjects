package com.phone.erp.websocket.listener;

import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.service.WebSocketSessionRegistryService;
import com.phone.erp.websocket.vo.WebSocketUser;
import org.chrisli.utils.encrypt.AESEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * [STOMP建立连接事件监听器]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Autowired
    private WebSocketSessionRegistryService webSocketSessionRegistryService;

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        // 获取客户端信息,并转换成WebSocket用户对象
        String origin = accessor.getNativeHeader("origin").get(0);
        String name = accessor.getNativeHeader("name").get(0);
        Client client = Client.getMatchedInstance(origin);
        String userId = AESEncoderUtil.decode(client.getSecretKey(), name);
        String sessionId = accessor.getSessionId();
        WebSocketUser webSocketUser = new WebSocketUser(String.format("[%s-%s-%s]", origin, name, sessionId), client, userId);
        // 将用户注册到在线用户集合中去
        if (!name.equals("770013C68D557893D92CC873F4597251")) {
            webSocketSessionRegistryService.registerWebSocketUser(webSocketUser);
        }
    }

}
