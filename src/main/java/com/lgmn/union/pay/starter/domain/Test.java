package com.lgmn.union.pay.starter.domain;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.union.pay.starter.utils.DataUtil;
import com.lgmn.union.pay.starter.utils.MD5Util;
import com.lgmn.union.pay.starter.utils.UnionPayPostUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.util.UUID;

public class Test {

//    public static void main(String[] args) {
//        // info
//        PaymentInfoEntity paymentInfoEntity = new PaymentInfoEntity();
//        paymentInfoEntity.setTRX_CODE("100005");
//        paymentInfoEntity.setVERSION("05");
//        paymentInfoEntity.setUSER_NAME("operator");
//        paymentInfoEntity.setUSER_PASS("ora_123456");
//        paymentInfoEntity.setREQ_SN(UUID.randomUUID().toString().replace("-", ""));
////        paymentInfoEntity.setSIGNED_MSG("12346");
//
//        // body/TRANS_SUM
//        PaymentTransSumEntity paymentTransSumEntity = new PaymentTransSumEntity();
//        paymentTransSumEntity.setBUSINESS_CODE("09100");
//        paymentTransSumEntity.setMERCHANT_ID("001053110000001");
//        paymentTransSumEntity.setSUBMIT_TIME(DataUtil.getNowDate_YYYYMMDDHHMMSS());
//        paymentTransSumEntity.setTOTAL_ITEM("1");
//        paymentTransSumEntity.setTOTAL_SUM(1);
//
//        // body/TRANS_DETAILS/TRANS_DETAIL
//        PaymentTransDetailEntity paymentTransDetailEntity = new PaymentTransDetailEntity();
//        paymentTransDetailEntity.setSN("00001");
//        paymentTransDetailEntity.setACCOUNT_NO("6227008888888999900");
//        paymentTransDetailEntity.setACCOUNT_NAME("王天鹏");
//        paymentTransDetailEntity.setAMOUNT(1);
//
//        // body/TRANS_DETAILS
//        PaymentTransDetailsEntity paymentTransDetailsEntity = new PaymentTransDetailsEntity();
//        paymentTransDetailsEntity.setTRANS_DETAIL(paymentTransDetailEntity);
//
//        // body
//        PaymentBodyEntity paymentBodyEntity = new PaymentBodyEntity();
//        paymentBodyEntity.setTRANS_SUM(paymentTransSumEntity);
//        paymentBodyEntity.setTRANS_DETAILS(paymentTransDetailsEntity);
//
//        // 全部
//        PaymentEntity paymentEntity = new PaymentEntity();
//        paymentEntity.setINFO(paymentInfoEntity);
//        paymentEntity.setBODY(paymentBodyEntity);
//
//        // 生成签名信息
//        XStream xStream = new XStream(new Xpp3Driver(new NoNameCoder()));
//        xStream.alias("GZELINK", paymentEntity.getClass());
//        String signXml = xStream.toXML(paymentEntity);
//        // 生成签名
//        String md5Xml = MD5Util.getMD5Code(signXml);
//        // 设置签名
//        paymentInfoEntity.setSIGNED_MSG("88b7b75954b16aee4f9254c2e8e553590bae47540b77b7f2aabd438297190efcc8b04ded4d4a0678a131dd40e75a68f764e49291ac4353724437a979d5cc12f30b2b62831dcb80e1dda7fba5c7714e7b2823b61936355e5fca8dd51b1c42675acb5f3995df48735f40a8e886e2133578ff1b188b1ead72ba515bf4de591fe2f1");
//
//        // 生成请求XML
//        String xml = xStream.toXML(paymentEntity);
//        JSONObject jsonObject = UnionPayPostUtil.getPostAssemble(xml, "https://59.41.103.102/gzdsf/ProcessServlet");
//        System.out.println("\n\n" + jsonObject + "\n\n");
//    }

}
