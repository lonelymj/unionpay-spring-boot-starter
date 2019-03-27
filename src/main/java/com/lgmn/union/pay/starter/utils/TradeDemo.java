package com.lgmn.union.pay.starter.utils;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.union.pay.starter.domain.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.util.UUID;

public class TradeDemo {
    public static void main(String[] args) throws Exception {
        TradeDemo tp = new TradeDemo( );
        TradeUtil.loadProperties();
        tp.testPay(xml());
    }

    private static String xml () {
        // info
        PaymentInfoEntity paymentInfoEntity = new PaymentInfoEntity();
        paymentInfoEntity.setTRX_CODE("100005");
        paymentInfoEntity.setVERSION("05");
        paymentInfoEntity.setUSER_NAME("operator");
        paymentInfoEntity.setUSER_PASS("ora_123456");
        paymentInfoEntity.setREQ_SN(UUID.randomUUID().toString().replace("-", ""));
//        paymentInfoEntity.setSIGNED_MSG("12346");

        // body/TRANS_SUM
        PaymentTransSumEntity paymentTransSumEntity = new PaymentTransSumEntity();
        paymentTransSumEntity.setBUSINESS_CODE("09100");
        paymentTransSumEntity.setMERCHANT_ID("001053110000001");
        paymentTransSumEntity.setSUBMIT_TIME(DataUtil.getNowDate_YYYYMMDDHHMMSS());
        paymentTransSumEntity.setTOTAL_ITEM("1");
        paymentTransSumEntity.setTOTAL_SUM(1);

        // body/TRANS_DETAILS/TRANS_DETAIL
        PaymentTransDetailEntity paymentTransDetailEntity = new PaymentTransDetailEntity();
        paymentTransDetailEntity.setSN("00001");
        paymentTransDetailEntity.setACCOUNT_NO("6227008888888999900");
        paymentTransDetailEntity.setACCOUNT_NAME("王天鹏");
        paymentTransDetailEntity.setAMOUNT(1);

        // body/TRANS_DETAILS
        PaymentTransDetailsEntity paymentTransDetailsEntity = new PaymentTransDetailsEntity();
        paymentTransDetailsEntity.setTRANS_DETAIL(paymentTransDetailEntity);

        // body
        PaymentBodyEntity paymentBodyEntity = new PaymentBodyEntity();
        paymentBodyEntity.setTRANS_SUM(paymentTransSumEntity);
        paymentBodyEntity.setTRANS_DETAILS(paymentTransDetailsEntity);

        // 全部
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setINFO(paymentInfoEntity);
        paymentEntity.setBODY(paymentBodyEntity);

        // 生成签名信息
        XStream xStream = new XStream(new Xpp3Driver(new NoNameCoder()));
        xStream.alias("GZELINK", paymentEntity.getClass());
        String signXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>" + xStream.toXML(paymentEntity);
        return signXml;
    }
    public void testPay(String strSendData) throws Exception{

        //请求报文 批量代收
//        String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK>	<INFO>		<TRX_CODE>100001</TRX_CODE>		<VERSION>04</VERSION>		<DATA_TYPE>2</DATA_TYPE>		<LEVEL>0</LEVEL>		<USER_NAME>operator</USER_NAME>		<USER_PASS>ora_123456</USER_PASS>		<REQ_SN>"+req+"</REQ_SN>		<SIGNED_MSG></SIGNED_MSG>	</INFO>	<BODY>		<TRANS_SUM>			<BUSINESS_CODE>10600</BUSINESS_CODE>			<MERCHANT_ID>001053110000001</MERCHANT_ID>			<SUBMIT_TIME>20170819155110</SUBMIT_TIME>			<TOTAL_ITEM>5</TOTAL_ITEM>			<TOTAL_SUM>15</TOTAL_SUM>		</TRANS_SUM>		<TRANS_DETAILS>			<TRANS_DETAIL>				<SN>0001</SN>				<E_USER_CODE/>				<BANK_CODE>102</BANK_CODE>				<ACCOUNT_TYPE>00</ACCOUNT_TYPE>				<ACCOUNT_NO>666228480081223030</ACCOUNT_NO>				<ACCOUNT_NAME>栾水</ACCOUNT_NAME>				<PROVINCE/>				<CITY/>				<BANK_NAME/>				<ACCOUNT_PROP>0</ACCOUNT_PROP>				<AMOUNT>1</AMOUNT>				<CURRENCY>CNY</CURRENCY>				<PROTOCOL/>				<PROTOCOL_USERID/>				<ID_TYPE/>				<ID/>				<TEL/>				<CUST_USERID/>				<RECKON_ACCOUNT></RECKON_ACCOUNT>				<REMARK/>				<RESERVE1/>				<RESERVE2/>			</TRANS_DETAIL>			<TRANS_DETAIL>				<SN>0002</SN>				<E_USER_CODE/>				<BANK_CODE>102</BANK_CODE>				<ACCOUNT_TYPE>00</ACCOUNT_TYPE>				<ACCOUNT_NO>6462270332418000</ACCOUNT_NO>				<ACCOUNT_NAME>望水一方</ACCOUNT_NAME>				<PROVINCE/>				<CITY/>				<BANK_NAME/>				<ACCOUNT_PROP>0</ACCOUNT_PROP>				<AMOUNT>2</AMOUNT>				<CURRENCY>CNY</CURRENCY>				<PROTOCOL/>				<PROTOCOL_USERID/>				<ID_TYPE/>				<ID/>				<TEL/>				<CUST_USERID/>				<RECKON_ACCOUNT></RECKON_ACCOUNT>				<REMARK/>				<RESERVE1/>				<RESERVE2/>			</TRANS_DETAIL>			<TRANS_DETAIL>				<SN>0003</SN>				<E_USER_CODE/>				<BANK_CODE>102</BANK_CODE>				<ACCOUNT_TYPE>00</ACCOUNT_TYPE>				<ACCOUNT_NO>44123342432542343</ACCOUNT_NO>				<ACCOUNT_NAME>郑乐</ACCOUNT_NAME>				<PROVINCE/>				<CITY/>				<BANK_NAME/>				<ACCOUNT_PROP>0</ACCOUNT_PROP>				<AMOUNT>3</AMOUNT>				<CURRENCY>CNY</CURRENCY>				<PROTOCOL/>				<PROTOCOL_USERID/>				<ID_TYPE/>				<ID/>				<TEL/>				<CUST_USERID/>				<RECKON_ACCOUNT>000191400100077</RECKON_ACCOUNT>				<REMARK/>				<RESERVE1/>				<RESERVE2/>			</TRANS_DETAIL>			<TRANS_DETAIL>				<SN>0004</SN>				<E_USER_CODE/>				<BANK_CODE>102</BANK_CODE>				<ACCOUNT_TYPE>00</ACCOUNT_TYPE>				<ACCOUNT_NO>44622700332418001</ACCOUNT_NO>				<ACCOUNT_NAME>栾望水</ACCOUNT_NAME>				<PROVINCE/>				<CITY/>				<BANK_NAME/>				<ACCOUNT_PROP>0</ACCOUNT_PROP>				<AMOUNT>4</AMOUNT>				<CURRENCY>CNY</CURRENCY>				<PROTOCOL/>				<PROTOCOL_USERID/>				<ID_TYPE/>				<ID/>				<TEL/>				<CUST_USERID/>				<RECKON_ACCOUNT/>				<REMARK/>				<RESERVE1/>				<RESERVE2/>			</TRANS_DETAIL>			<TRANS_DETAIL>				<SN>0005</SN>				<E_USER_CODE/>				<BANK_CODE>105</BANK_CODE>				<ACCOUNT_TYPE>00</ACCOUNT_TYPE>				<ACCOUNT_NO>44-622700332418001</ACCOUNT_NO>				<ACCOUNT_NAME>高山水</ACCOUNT_NAME>				<PROVINCE/>				<CITY/>				<BANK_NAME/>				<ACCOUNT_PROP>0</ACCOUNT_PROP>				<AMOUNT>5</AMOUNT>				<CURRENCY>CNY</CURRENCY>				<PROTOCOL/>				<PROTOCOL_USERID/>				<ID_TYPE/>				<ID/>				<TEL/>				<CUST_USERID/>				<RECKON_ACCOUNT/>				<REMARK/>				<RESERVE1/>				<RESERVE2/>			</TRANS_DETAIL>		</TRANS_DETAILS>	</BODY></GZELINK>";
        //请求报文 实时代收
//        String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO>   <TRX_CODE>100004</TRX_CODE>   <VERSION>04</VERSION>  <DATA_TYPE>2</DATA_TYPE> <LEVEL>0</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>ora_123456</USER_PASS><REQ_SN>201708291525471ADFADdD111</REQ_SN> <SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><BUSINESS_CODE>10600</BUSINESS_CODE><MERCHANT_ID>001053110000001</MERCHANT_ID><SUBMIT_TIME>20170801122121</SUBMIT_TIME><TOTAL_ITEM>1</TOTAL_ITEM><TOTAL_SUM>100</TOTAL_SUM></TRANS_SUM><TRANS_DETAILS><TRANS_DETAIL><SN>0001</SN><E_USER_CODE/><BANK_CODE>102</BANK_CODE><ACCOUNT_TYPE>00</ACCOUNT_TYPE><ACCOUNT_NO>655880360213125310</ACCOUNT_NO><ACCOUNT_NAME>测试卡户名</ACCOUNT_NAME><PROVINCE/><CITY/><BANK_NAME/><ACCOUNT_PROP>0</ACCOUNT_PROP><AMOUNT>100</AMOUNT><CURRENCY>CNY</CURRENCY><PROTOCOL/><PROTOCOL_USERID/><ID_TYPE/><ID/><TEL/><CUST_USERID/><RECKON_ACCOUNT></RECKON_ACCOUNT><REMARK/><RESERVE1/><RESERVE2/></TRANS_DETAIL></TRANS_DETAILS></BODY></GZELINK>";
        //请求报文 银行卡四要素验证
        //String strSendData = "<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK><INFO><TRX_CODE>100039</TRX_CODE><VERSION>03</VERSION><DATA_TYPE>2</DATA_TYPE><LEVEL>5</LEVEL><USER_NAME>operator</USER_NAME><USER_PASS>ora_123456</USER_PASS><REQ_SN>898bf35f8a45c8974015b1b</REQ_SN><SIGNED_MSG></SIGNED_MSG></INFO><BODY><TRANS_SUM><SUBMIT_TIME>20170825145319</SUBMIT_TIME><MERCHANT_ID>001053110000001</MERCHANT_ID><ACCOUNT_NO>6227008888888999900</ACCOUNT_NO><ACCOUNT_NAME>王天鹏</ACCOUNT_NAME><ID_TYPE>0</ID_TYPE><ID>63010119450601271X</ID><TEL>13698520009</TEL></TRANS_SUM></BODY></GZELINK>";

        //1、签名
        strSendData = TradeUtil.signTradeMsg(strSendData);
        System.out.println("发送报文："+strSendData);
        try{
            CommonHttpURLConnection conn = new CommonHttpURLConnection();
            //2、发送报文
            String retMsg = conn.postHttpMsg(TradeUtil.getUrl(), strSendData);
            //验签
            System.out.println(retMsg);
            if (TradeUtil.verifyTradeMsg(retMsg.toString())) {
            }
        }catch(Exception ex){
        }
    }

}
