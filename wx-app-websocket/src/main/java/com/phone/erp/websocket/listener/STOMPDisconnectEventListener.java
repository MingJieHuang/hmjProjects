package com.phone.erp.websocket.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.phone.erp.websocket.service.WebSocketSessionRegistryService;
import com.phone.erp.websocket.vo.WebSocketUser;

/**
 * [STOMP断开连接事件监听器]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class STOMPDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {

    @Autowired
    private WebSocketSessionRegistryService webSocketSessionRegistryService;

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        WebSocketUser webSocketUser = (WebSocketUser) event.getUser();
        // 将用户移出在线集合
        webSocketSessionRegistryService.removeWebSocketUser(webSocketUser);
    }

}
