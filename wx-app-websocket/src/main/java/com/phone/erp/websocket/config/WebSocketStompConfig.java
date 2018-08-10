package com.phone.erp.websocket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.phone.erp.websocket.interceptor.UserInterceptor;
import com.phone.erp.websocket.listener.STOMPConnectEventListener;
import com.phone.erp.websocket.listener.STOMPDisconnectEventListener;

/**
 * [WebSocket STOMP配置]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Value("${project.url.prefix}")
	private String projectUrlPrefix;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 设置端点,客户端通过http://localhost:8800/api/v1/ws/webSocketServer来和服务器进行websocket连接
		registry.addEndpoint(projectUrlPrefix + "/webSocketServer").setAllowedOrigins("*").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 订阅Broker名称
		registry.enableSimpleBroker("/queue", "/topic");
		// 设置客户端请求前缀 ,全局使用的消息前缀(客户端订阅路径上会体现出来)
		registry.setApplicationDestinationPrefixes("/app");
		// 点对点使用的订阅前缀(客户端订阅路径上会体现出来),不设置的话,默认也是/user/
		registry.setUserDestinationPrefix("/user/");
	}

	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.setInterceptors(createUserInterceptor());
	}

	@Bean
	public UserInterceptor createUserInterceptor() {
		return new UserInterceptor();
	}

	@Bean
	public STOMPConnectEventListener connectEventListener() {
		return new STOMPConnectEventListener();
	}

	@Bean
	public STOMPDisconnectEventListener disconnectEventListener() {
		return new STOMPDisconnectEventListener();
	}
}