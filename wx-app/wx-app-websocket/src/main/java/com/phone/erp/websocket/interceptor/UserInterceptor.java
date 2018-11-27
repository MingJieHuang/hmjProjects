package com.phone.erp.websocket.interceptor;

import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.vo.WebSocketUser;
import org.chrisli.utils.encrypt.AESEncoderUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * [用户拦截器]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class UserInterceptor extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
		if (StompCommand.CONNECT.equals(accessor.getCommand())) {
			// 第一次建立连接,获取客户端信息,并转换成WebSocket用户对象
			String origin = accessor.getNativeHeader("origin").get(0);
			String name = accessor.getNativeHeader("name").get(0);
			Client client = Client.getMatchedInstance(origin);
			String userId = AESEncoderUtil.decode(client.getSecretKey(), name);
			String sessionId = accessor.getSessionId();
			// 添加到用户列表中
			accessor.setUser(new WebSocketUser(String.format("[%s-%s-%s]", origin, name, sessionId), client, userId));
		}
		return message;
	}
}