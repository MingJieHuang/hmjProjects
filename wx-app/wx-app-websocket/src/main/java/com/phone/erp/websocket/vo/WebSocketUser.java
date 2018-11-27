package com.phone.erp.websocket.vo;

import com.phone.erp.websocket.enums.Client;

import java.security.Principal;

/**
 * [websocket通信的用户对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public final class WebSocketUser implements Principal {
    /**
     * websocket客户端实例的唯一名称
     */
    private final String name;
    /**
     * 对应的客户端
     */
    private Client client;
    /**
     * 用户主键
     */
    private String userId;

    public WebSocketUser(String name, Client client, String userId) {
        this.name = name;
        this.client = client;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "WebSocketUser [client=" + client + ", name=" + name + ", userId=" + userId + "]";
    }

}
