package com.phone.erp.websocket.enums;

import com.phone.erp.base.utils.Assert;
import org.chrisli.utils.exception.AssertFailedException;

/**
 * [websocket客户端]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public enum Client {
	ERP("ERP", "ERP系统", 1, "ERP-WS-SK-YSSOFT"), ;

	/**
	 * 编码
	 */
	private final String code;
	/**
	 * 名称
	 */
	private final String name;
	/**
	 * 类型
	 */
	private final Integer type;
	/**
	 * 加解密密钥
	 */
	private final String secretKey;

	Client(String code, String name, Integer type, String secretKey) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.secretKey = secretKey;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Integer getType() {
		return type;
	}

	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * [获取匹配的实例]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static Client getMatchedInstance(String code) {
		Assert.notBlank(code, "websocket客户端编号不允许为空!");
		for (Client client : Client.values()) {
			if (client.getCode().equalsIgnoreCase(code)) {
				return client;
			}
		}
		throw new AssertFailedException(String.format("非法的websocket客户端编号[%s]", code));
	}
}
