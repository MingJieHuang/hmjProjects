package com.phone.erp.websocket.vo.retail;

/**
 * [云打印参数消息对象]
 *
 * @author Chris li[黎超]
 * @version [版本, 2017-04-12]
 * @see
 */
public class ParamMessageVo {

    public ParamMessageVo() {
    }

    public ParamMessageVo(String computerCode, Long billsId, Integer onlinePayFlag) {
        setComputerCode(computerCode);
        setBillsId(billsId);
        setOnlinePayFlag(onlinePayFlag);
    }

    /**
     * 打印电脑编号
     */
    private String computerCode;
    /**
     * 打印零售单id
     */
    private Long billsId;
    /**
     * 在线支付标记
     */
    private Integer onlinePayFlag;

    public String getComputerCode() {
        return computerCode;
    }

    public void setComputerCode(String computerCode) {
        this.computerCode = computerCode;
    }

    public Long getBillsId() {
        return billsId;
    }

    public void setBillsId(Long billsId) {
        this.billsId = billsId;
    }

    public Integer getOnlinePayFlag() {
        return onlinePayFlag;
    }

    public void setOnlinePayFlag(Integer onlinePayFlag) {
        this.onlinePayFlag = onlinePayFlag;
    }

}
