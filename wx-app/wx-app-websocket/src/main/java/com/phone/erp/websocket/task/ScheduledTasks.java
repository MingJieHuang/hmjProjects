package com.phone.erp.websocket.task;

import com.phone.erp.websocket.enums.Client;
import com.phone.erp.websocket.service.WebSocketSessionRegistryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.util.ArrayList;
import java.util.List;

/**
 * [定时任务类]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebSocketSessionRegistryService webSocketSessionRegistryService;

    /**
     * [每天晚上10点,清理ERP系统使用期限到期的用户,强制踢下线]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    @Scheduled(cron = "${scheduled.task.erp.cron.expired.employee}")
    public void kickOutExpiredEmployee() {
        logger.info("开始清理ERP系统中已到期的在线用户...");
        webSocketSessionRegistryService.kickOutExpiredOnLineEmployee(Client.ERP);
    }

    /**
     * [测试创建websocket客户端]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public void minitor() {
        List<Transport> transports = new ArrayList<Transport>();
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        transports.add(new WebSocketTransport(new StandardWebSocketClient(webSocketContainer)));
        WebSocketClient transport = new SockJsClient(transports);
        final WebSocketStompClient stompClient = new WebSocketStompClient(transport);
        String url = "ws://localhost:8800/webSocketServer";
        StompHeaders connectHeaders = new StompHeaders();
        connectHeaders.set("origin", "ERP");
        connectHeaders.set("name", "770013C68D557893D92CC873F4597251");
        stompClient.setDefaultHeartbeat(new long[]{0, 0});
        stompClient.connect(url, null, connectHeaders, new StompSessionHandlerAdapter() {
            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                session.disconnect();
            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {
                logger.error("异常", exception);
            }

            @Override
            public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
                logger.error("异常", exception);
            }
        }, new Object[]{});
    }

}
