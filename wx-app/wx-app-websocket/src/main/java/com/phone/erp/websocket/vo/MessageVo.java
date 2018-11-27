package com.phone.erp.websocket.vo;

/**
 * [消息对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class MessageVo {
    /**
     * 命令
     */
    private String command;
    /**
     * 参数
     */
    private String param;

    public MessageVo() {
    }

    public MessageVo(String command) {
        setCommand(command);
    }

    public MessageVo(String command, String param) {
        setCommand(command);
        setParam(param);
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "MessageVo [command=" + command + ", param=" + param + "]";
    }

}
