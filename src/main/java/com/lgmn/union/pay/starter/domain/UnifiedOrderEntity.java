package com.lgmn.union.pay.starter.domain;

import java.util.Date;

/**
 * 统一下单
 */
public class UnifiedOrderEntity {

    /**
     * 必传 ： false
     * <p>
     * 消息ID，原样返回
     */
    private String msgId;

    /**
     * 必传 ： true
     * <p>
     * 消息来源
     * <p>
     * 请求来源
     */
    private String msgSrc;

    /**
     * 必传 ： true
     * <p>
     * 消息类型
     * <p>
     * 微信:wx.unifiedOrder
     * 支付宝:trade.precreate
     * 全民付:qmf.order
     * 银联云闪付（走银联全渠道）:uac.appOrder
     */
    private String msgType;

    /**
     * 请勿传此参数
     * 必传 ： true
     * <p>
     * 报文请求时间，格式yyyy-MM-dd HH:mm:ss
     * <p>
     * yyyy-MM-dd HH:mm:ss
     */
    private String requestTimestamp;

    /**
     * 必传 ： true
     * <p>
     * 商户自行生成
     * 注意：长度不要超过32位。
     * 银商规范，以银商分配的4位系统编号作为订单号的前4位，且在商户系统中此订单号保证唯一。总长度需大于6位，小于32位
     */
    private String merOrderId;

    /**
     * 必传 ： false
     * <p>
     * 请求系统预留字段
     */
    private String srcReserve;

    /**
     * 请在配置文件配置此参数
     * 必传 ： true
     * <p>
     * 商户订单号
     */
    private String mid;

    /**
     * 请在配置文件配置此参数
     * 必传 ： true
     * <p>
     * 终端号
     */
    private String tid;

    /**
     * 请在配置文件配置此参数
     * 必传 ： true
     * <p>
     * 机构商户号
     * <p>
     * APPDEFAULT
     */
    private String instMid;

    /**
     * 订单信息
     */
    private Goods goods;

    /**
     * 必传 ： false
     * <p>
     * 商户附加数据
     */
    private String attachedData;

    /**
     * 必传 ： false
     * <p>
     * 订单过期时间
     * <p>
     * 订单过期时间，为空则使用系统默认过期时间（30分钟），格式yyyy-MM-dd HH:mm:ss
     */
    private Date expireTime;

    /**
     * 必传 ： false
     * <p>
     * 商品标记，用于优惠活动
     * <p>
     * 跟goods字段二选一，商品信息通过goods.add接口提前上送
     */
    private String goodsTag;

    /**
     * 必传 ： false
     * <p>
     * 商品交易单号
     * <p>
     * 跟goods字段二选一，商品信息通过goods.add接口提前上送
     */
    private String goodsTradeNo;

    /**
     * 必传 ： false
     * <p>
     * 订单描述
     */
    private String orderDesc;

    /**
     * 必传 ： false
     * <p>
     * 订单原始金额，单位分，用于记录前端系统打折前的金额
     */
    private Long originalAmount;

    /**
     * 必传 ： false
     * <p>
     * 商品ID
     */
    private String productId;

    /**
     * 必传 ： true
     * <p>
     * 支付总金额，单位分
     * <p>
     * 若divisionFlag为true，则：
     * totalAmount  =  subOrders字段中的所有totalAmount值之和 加上 platformAmount值 =  goods中的所有subOrderAmount值之和
     */
    private Integer totalAmount;

    /**
     * 必传 ： false
     * <p>
     * 分账标记
     * <p>
     * 暂时只支持微信（WXPay.jsPay）、支付宝
     * （trade.jsPay）支付 和 银联云闪付（uac.appOrder）。
     * 若为true，则goods字段和subOrders字段不能同时为空；
     * 且secureTransaction字段上送false或不上送。
     */
    private Boolean divisionFlag;

    /**
     * 必传 ： false
     * <p>
     * 平台商户分账金额
     * <p>
     * 若分账标记传，则分账金额必传
     */
    private Integer platformAmount;

    /**
     * 必传 ： false
     * <p>
     * 在传分账标记的情况下，若传子商户号，子商户分账金额必传，即ubOrders每个元素的mid和totalAmount非空 且 mid不超过20个
     */
    private SubOrders subOrders;

    /**
     * 必传 ： false
     * <p>
     * 支付结果通知地址
     */
    private String notifyUrl;

    /**
     * 必传 ： false
     * <p>
     * 订单展示页面
     */
    private String showUrl;

    /**
     * 必传 ： false
     * <p>
     * 签名算法
     * <p>
     * 值为：MD5或 SHA256
     */
    private String signType;

    /**
     * 必传 ： false
     * <p>
     * 交易类型
     * <p>
     * 微信必传:APP
     */
    private String tradeType;

    /**
     * 必传 ： false
     * <p>
     * 商户用户号
     * <p>
     * 全民付必传
     */
    private String merchantUserId;

    /**
     * 必传 ： false
     * <p>
     * 手机号
     * <p>
     * 全民付必传
     */
    private String mobile;

    /**
     * 必传 ： false
     * <p>
     * 标识是否是担保交易
     * <p>
     * 取值：true或false，默认false
     * 若上送为true，则交易的金额将会被暂缓结算。
     * 调用担保完成接口后，完成部分金额会在t+1日结算给商户，剩余部分金额退还用户。
     * 调用担保撤销接口，则全部资金退还给用户。
     * 30天后 没有主动调用担保完成 且 没有主动调用担保撤销的交易 将会自动按撤销处理。
     */
    private String secureTransaction;

    /**
     * 必传 ： false
     * <p>
     * 是否需要限制信用卡支付
     * <p>
     * 取值：true或false，默认false
     */
    private String limitCreditCard;

    /**
     * 必传 ： true
     * <p>
     * 签名
     */
    private String sign;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(String requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public String getMerOrderId() {
        return merOrderId;
    }

    public void setMerOrderId(String merOrderId) {
        this.merOrderId = merOrderId;
    }

    public String getSrcReserve() {
        return srcReserve;
    }

    public void setSrcReserve(String srcReserve) {
        this.srcReserve = srcReserve;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getInstMid() {
        return instMid;
    }

    public void setInstMid(String instMid) {
        this.instMid = instMid;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getAttachedData() {
        return attachedData;
    }

    public void setAttachedData(String attachedData) {
        this.attachedData = attachedData;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getGoodsTradeNo() {
        return goodsTradeNo;
    }

    public void setGoodsTradeNo(String goodsTradeNo) {
        this.goodsTradeNo = goodsTradeNo;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Long getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Long originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getDivisionFlag() {
        return divisionFlag;
    }

    public void setDivisionFlag(Boolean divisionFlag) {
        this.divisionFlag = divisionFlag;
    }

    public Integer getPlatformAmount() {
        return platformAmount;
    }

    public void setPlatformAmount(Integer platformAmount) {
        this.platformAmount = platformAmount;
    }

    public SubOrders getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(SubOrders subOrders) {
        this.subOrders = subOrders;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(String merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSecureTransaction() {
        return secureTransaction;
    }

    public void setSecureTransaction(String secureTransaction) {
        this.secureTransaction = secureTransaction;
    }

    public String getLimitCreditCard() {
        return limitCreditCard;
    }

    public void setLimitCreditCard(String limitCreditCard) {
        this.limitCreditCard = limitCreditCard;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "UnifiedOrderEntity{" +
                "msgId='" + msgId + '\'' +
                ", msgSrc='" + msgSrc + '\'' +
                ", msgType='" + msgType + '\'' +
                ", requestTimestamp=" + requestTimestamp +
                ", merOrderId='" + merOrderId + '\'' +
                ", srcReserve='" + srcReserve + '\'' +
                ", mid='" + mid + '\'' +
                ", tid='" + tid + '\'' +
                ", instMid='" + instMid + '\'' +
                ", goods=" + goods +
                ", attachedData='" + attachedData + '\'' +
                ", expireTime=" + expireTime +
                ", goodsTag='" + goodsTag + '\'' +
                ", goodsTradeNo='" + goodsTradeNo + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", originalAmount=" + originalAmount +
                ", productId='" + productId + '\'' +
                ", totalAmount=" + totalAmount +
                ", divisionFlag=" + divisionFlag +
                ", platformAmount=" + platformAmount +
                ", subOrders=" + subOrders +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", showUrl='" + showUrl + '\'' +
                ", signType='" + signType + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", merchantUserId='" + merchantUserId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", secureTransaction='" + secureTransaction + '\'' +
                ", limitCreditCard='" + limitCreditCard + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
