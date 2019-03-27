package com.lgmn.union.pay.starter.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaymentTransDetailEntity {

    /**
     * 非空
     * 记录序号
     * 同一个请求内必须唯一。建议从0001开始递增
     */
    @JsonProperty("SN")
    private String SN;

    /**
     * 可空
     * 银联网络用户编号
     * 银联网络客户编号
     */
    @JsonProperty("E_USER_CODE")
    private String E_USER_CODE;

    /**
     * 可空
     * 银行代码
     * 3 - 8位的银行代码
     */
    @JsonProperty("BANK_CODE")
    private String BANK_CODE;

    /**
     * 可空
     * 账号类型
     * 00银行卡，01存折。
     */
    @JsonProperty("ACCOUNT_TYPE")
    private String ACCOUNT_TYPE;

    /**
     * 非空
     * 账号
     * 银行卡或存折号码
     */
    @JsonProperty("ACCOUNT_NO")
    private String ACCOUNT_NO;

    /**
     * 非空
     * 账号名
     * 银行卡或存折上的所有人姓名
     */
    @JsonProperty("ACCOUNT_NAME")
    private String ACCOUNT_NAME;

    /**
     * 可空
     * 开户行所在省
     * 不带“省”或“自治区”，如 广东，广西，内蒙古等。建议根据后附的中国邮政区号表内的“省洲名称”列的内容填写
     */
    @JsonProperty("PROVINCE")
    private String PROVINCE;

    /**
     * 可空
     * 开户行所在市
     * 不带“市”，如 广州，南宁等。
     * 如果是直辖市，则填区，如北京（市）朝阳（区）。
     * 建议根据后附的中国邮政区号表内的“地区名称”列的内容填写
     */
    @JsonProperty("CITY")
    private String CITY;

    /**
     * 可空
     * 开户行名称
     * 开户行详细名称，也叫网点，如 中国建设银行广州东山广场分理处
     */
    @JsonProperty("BANK_NAME")
    private String BANK_NAME;

    /**
     * 可空
     * 账号属性
     * 0私人，1公司。不填时，默认为私人0
     */
    @JsonProperty("ACCOUNT_PROP")
    private String ACCOUNT_PROP;

    /**
     * 非空
     * 金额
     * 整数，单位分
     */
    @JsonProperty("AMOUNT")
    private Integer AMOUNT;

    /**
     * 可空
     * 货币类型
     * 人民币：CNY, 港元：HKD，美元：USD。不填时，默认为人民币。
     */
    @JsonProperty("CURRENCY")
    private String CURRENCY;

    /**
     * 可空
     * 协议号
     */
    @JsonProperty("PROTOCOL")
    private String PROTOCOL;

    /**
     * 可空
     * 协议用户编号
     */
    @JsonProperty("PROTOCOL_USERID")
    private String PROTOCOL_USERID;

    /**
     * 可空
     * 开户证件类型
     * 0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件
     */
    @JsonProperty("ID_TYPE")
    private String ID_TYPE;

    /**
     * 可空
     * 证件号
     */
    @JsonProperty("ID")
    private String ID;

    /**
     * 可空
     * 手机号/小灵通
     * 小灵通带区号，不带括号，减号
     */
    @JsonProperty("TEL")
    private String TEL;

    /**
     * 可空
     * 清算账号
     * 资金清算账号
     */
    @JsonProperty("RECKON_ACCOUNT")
    private String RECKON_ACCOUNT;

    /**
     * 可空
     * 自定义用户号
     * 商户自定义的用户号， 用户号要唯一
     */
    @JsonProperty("CUST_USERID")
    private String CUST_USERID;

    /**
     * 可空
     * 备注
     * 供商户填入参考信息
     */
    @JsonProperty("REMARK")
    private String REMARK;

    /**
     * 可空
     * 保留域1
     * 备用字段1
     */
    @JsonProperty("RESERVE1")
    private String RESERVE1;

    /**
     * 可空
     * 保留域2
     * 备用字段2
     */
    @JsonProperty("RESERVE2")
    private String RESERVE2;

    /**
     * 可空
     * 保留域3
     * 备用字段3
     */
    @JsonProperty("RESERVE3")
    private String RESERVE3;

    /**
     * 可空
     * 保留域4
     * 备用字段4
     */
    @JsonProperty("RESERVE4")
    private String RESERVE4;

    /**
     * 可空
     * 电子联行号
     */
    @JsonProperty("ELE_BANKNO")
    private String ELE_BANKNO;

    /**
     * 可空
     * 摘要
     */
    @JsonProperty("ABS")
    private String ABS;

    /**
     * 可空
     * 附言
     */
    @JsonProperty("PS")
    private String PS;

    /**
     * 可空
     * 用途
     */
    @JsonProperty("USE")
    private String USE;

    /**
     * 可空
     * 信用卡有效期
     * YYMM
     */
    @JsonProperty("CRE_VAL_DATE")
    private String CRE_VAL_DATE;

    /**
     * 可空
     * CVN2码
     */
    @JsonProperty("CRE_CVN2")
    private String CRE_CVN2;

    /**
     * 可空
     * 账号密码
     */
    @JsonProperty("ACC_PASS")
    private String ACC_PASS;

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getE_USER_CODE() {
        return E_USER_CODE;
    }

    public void setE_USER_CODE(String e_USER_CODE) {
        E_USER_CODE = e_USER_CODE;
    }

    public String getBANK_CODE() {
        return BANK_CODE;
    }

    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getPROVINCE() {
        return PROVINCE;
    }

    public void setPROVINCE(String PROVINCE) {
        this.PROVINCE = PROVINCE;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getBANK_NAME() {
        return BANK_NAME;
    }

    public void setBANK_NAME(String BANK_NAME) {
        this.BANK_NAME = BANK_NAME;
    }

    public String getACCOUNT_PROP() {
        return ACCOUNT_PROP;
    }

    public void setACCOUNT_PROP(String ACCOUNT_PROP) {
        this.ACCOUNT_PROP = ACCOUNT_PROP;
    }

    public Integer getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(Integer AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getPROTOCOL() {
        return PROTOCOL;
    }

    public void setPROTOCOL(String PROTOCOL) {
        this.PROTOCOL = PROTOCOL;
    }

    public String getPROTOCOL_USERID() {
        return PROTOCOL_USERID;
    }

    public void setPROTOCOL_USERID(String PROTOCOL_USERID) {
        this.PROTOCOL_USERID = PROTOCOL_USERID;
    }

    public String getID_TYPE() {
        return ID_TYPE;
    }

    public void setID_TYPE(String ID_TYPE) {
        this.ID_TYPE = ID_TYPE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getRECKON_ACCOUNT() {
        return RECKON_ACCOUNT;
    }

    public void setRECKON_ACCOUNT(String RECKON_ACCOUNT) {
        this.RECKON_ACCOUNT = RECKON_ACCOUNT;
    }

    public String getCUST_USERID() {
        return CUST_USERID;
    }

    public void setCUST_USERID(String CUST_USERID) {
        this.CUST_USERID = CUST_USERID;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public String getRESERVE1() {
        return RESERVE1;
    }

    public void setRESERVE1(String RESERVE1) {
        this.RESERVE1 = RESERVE1;
    }

    public String getRESERVE2() {
        return RESERVE2;
    }

    public void setRESERVE2(String RESERVE2) {
        this.RESERVE2 = RESERVE2;
    }

    public String getRESERVE3() {
        return RESERVE3;
    }

    public void setRESERVE3(String RESERVE3) {
        this.RESERVE3 = RESERVE3;
    }

    public String getRESERVE4() {
        return RESERVE4;
    }

    public void setRESERVE4(String RESERVE4) {
        this.RESERVE4 = RESERVE4;
    }

    public String getELE_BANKNO() {
        return ELE_BANKNO;
    }

    public void setELE_BANKNO(String ELE_BANKNO) {
        this.ELE_BANKNO = ELE_BANKNO;
    }

    public String getABS() {
        return ABS;
    }

    public void setABS(String ABS) {
        this.ABS = ABS;
    }

    public String getPS() {
        return PS;
    }

    public void setPS(String PS) {
        this.PS = PS;
    }

    public String getUSE() {
        return USE;
    }

    public void setUSE(String USE) {
        this.USE = USE;
    }

    public String getCRE_VAL_DATE() {
        return CRE_VAL_DATE;
    }

    public void setCRE_VAL_DATE(String CRE_VAL_DATE) {
        this.CRE_VAL_DATE = CRE_VAL_DATE;
    }

    public String getCRE_CVN2() {
        return CRE_CVN2;
    }

    public void setCRE_CVN2(String CRE_CVN2) {
        this.CRE_CVN2 = CRE_CVN2;
    }

    public String getACC_PASS() {
        return ACC_PASS;
    }

    public void setACC_PASS(String ACC_PASS) {
        this.ACC_PASS = ACC_PASS;
    }
}
