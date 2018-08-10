package com.phone.erp.websocket.enums;

import com.phone.erp.base.utils.Assert;
import org.chrisli.utils.exception.AssertFailedException;

/**
 * [WebSocket操作动作]
 * 
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public enum Action {
	/**
	 * 进入主页面时,踢出本账号之前的登录
	 */
	REPEAT_KICK_OUT("REPEAT_KICK_OUT", "重复登录踢出"),
	/**
	 * 保存角色授权后,踢出本角色下所有在线员工的登录
	 */
	AUTH_KICK_OUT("AUTH_KICK_OUT", "重新授权踢出"),
	/**
	 * 管理员强制踢出指定在线员工的登录
	 */
	FORCE_KICK_OUT("FORCE_KICK_OUT", "强制踢出"),
	/**
	 * 系统定时踢出已过期在线员工的登录
	 */
	EXPIRED_KICK_OUT("EXPIRED_KICK_OUT", "过期踢出"),
	/**
	 * 绑定用户登录的电脑编码
	 */
	BIND_LOGIN_COMPUTER("BIND_LOGIN_COMPUTER", "绑定登录电脑"),
	/**
	 * 打印零售单
	 */
	PRINT_RETAIL_ORDER("PRINT_RETAIL_ORDER", "打印零售单"), ;

	/**
	 * 编码
	 */
	private final String code;
	/**
	 * 名称
	 */
	private final String name;

	Action(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	/**
	 * [获取匹配的实例]
	 * 
	 * @author Chris li[黎超]
	 * @version [版本, 2017-04-12]
	 */
	public static Action getMatchedInstance(String code) {
		Assert.notBlank(code, "websocket操作指令不允许为空!");
		for (Action action : Action.values()) {
			if (action.getCode().equalsIgnoreCase(code)) {
				return action;
			}
		}
		throw new AssertFailedException(String.format("非法的操作指令[%s]", code));
	}
}
