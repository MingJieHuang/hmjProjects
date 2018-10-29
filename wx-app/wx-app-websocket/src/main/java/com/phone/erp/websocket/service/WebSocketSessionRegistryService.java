package com.phone.erp.websocket.service;

import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.vo.MessageVo;
import com.phone.erp.websocket.vo.SendMessageResult;
import com.phone.erp.websocket.vo.WebSocketUser;

/**
 * [WebSocket Session注册服务]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public interface WebSocketSessionRegistryService {

    /**
     * [注册WebSocket用户]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void registerWebSocketUser(WebSocketUser webSocketUser);

    /**
     * [移除WebSocket用户]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    void removeWebSocketUser(WebSocketUser webSocketUser);

    /**
     * [处理客户端发送的消息]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    SendMessageResult handlerClientMessage(WebSocketUser webSocketUser, MessageVo actionVo);

    /**
     * [踢出指定客户端的过期的在线用户]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    SendMessageResult kickOutExpiredOnLineEmployee(Client client);
}
