package com.phone.erp.websocket.vo.login;

import java.util.Date;

/**
 * [客户登录状态VO对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class LoginStatusVo {
    /**
     * 主键
     */
    private Long id;
    /**
     * 集团id
     */
    private Long groupId;
    /**
     * 员工id
     */
    private Long employeeId;
    /**
     * 登录平台
     */
    private Integer platform;
    /**
     * 登录状态(0:在线;1:离线)
     */
    private Integer loginStatus;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 退出时间
     */
    private Date logoutTime;
    /**
     * WebSocket客户端名称
     */
    private String wsClientName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public void setWsClientName(String wsClientName) {
        this.wsClientName = wsClientName;
    }

    public String getWsClientName() {
        return wsClientName;
    }

}
