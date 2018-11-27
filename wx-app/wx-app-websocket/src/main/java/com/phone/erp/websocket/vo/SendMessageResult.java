package com.phone.erp.websocket.vo;


import org.apache.commons.lang3.StringUtils;

/**
 * [调用发送消息方法的执行结果]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class SendMessageResult {
    /**
     * 是否发送
     */
    private boolean hasSended = false;
    /**
     * 发送的消息总数
     */
    private int sendedCount = 0;
    /**
     * 错误信息
     */
    private String errorMsg;

    public boolean hasSended() {
        return hasSended;
    }

    public void setSendedCount(int sendedCount) {
        this.sendedCount = sendedCount;
        this.hasSended = sendedCount > 0;
    }

    public int getSendedCount() {
        return sendedCount;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * [已发送的数量加1]
     *
     * @author Chris li[黎超]
     * @version [版本, 2017-04-12]
     */
    public void addSendedCount() {
        setSendedCount(this.sendedCount + 1);
    }

    @Override
    public String toString() {
        if (StringUtils.isNotBlank(errorMsg)) {
            return String.format("消息发送状态:[%b], 发送的消息总数:[%d], 异常消息:[%s].", hasSended, sendedCount, errorMsg);
        }
        return String.format("消息发送状态:[%b], 发送的消息总数:[%d].", hasSended, sendedCount);
    }

}
