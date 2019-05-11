package com.lgmn.union.pay.starter.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.lgmn.union.pay.starter.domain.UnifiedOrderEntity;
import com.lgmn.union.pay.starter.utils.DataUtil;
import com.lgmn.union.pay.starter.utils.SerializableUtil;
import com.lgmn.union.pay.starter.utils.UnionPayPostUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 统一下单
 */
public class UnionPay_UnifiedOrder_SarterService {

    private final static String UNIONPAY_UNIFIEDORDER_URI_TEST = "https://qr-test2.chinaums.com/netpay-route-server/api/";

    private final static String UNIONPAY_UNIFIEDORDER_URI = "https://qr.chinaums.com/netpay-route-server/api/";

    private final static String UNIONPAY_QUERYPAYSTATUS_URI_TEST = "https://qr-test2.chinaums.com/netpay-route-server/api/";

    private final static String UNIONPAY_QUERYPAYSTATUS_URI = "https://qr.chinaums.com/netpay-route-server/api/";

    private String mid;
    private String tid;
    private String instMid;
    private Boolean isTest;
    private String orderNoPrefix;
    private String msgSrc;
    private String key;

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

    public Boolean getTest() {
        return isTest;
    }

    public void setTest(Boolean test) {
        isTest = test;
    }

    public String getOrderNoPrefix() {
        return orderNoPrefix;
    }

    public void setOrderNoPrefix(String orderNoPrefix) {
        this.orderNoPrefix = orderNoPrefix;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public UnionPay_UnifiedOrder_SarterService(String mid, String tid, String instMid, Boolean isTest, String orderNoPrefix, String msgSrc, String key) {
        this.mid = mid;
        this.tid = tid;
        this.instMid = instMid;
        this.isTest = isTest;
        this.orderNoPrefix = orderNoPrefix;
        this.msgSrc = msgSrc;
        this.key = key;
    }

    /**
     * 统一下单请求
     *
     * @param unifiedOrderEntity 传参
     *                           请在配置文件配置如下参数
     *                           mid
     *                           tid
     *                           instMid
     *                           isTest
     *                           请勿传此参数
     *                           requestTimestamp
     * @return
     */
    public JSONObject postUnionPay_UnifiedOrde(UnifiedOrderEntity unifiedOrderEntity) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        unifiedOrderEntity.setMid(mid);
        unifiedOrderEntity.setTid(tid);
        unifiedOrderEntity.setInstMid(instMid);
        unifiedOrderEntity.setMerOrderId(orderNoPrefix + unifiedOrderEntity.getMerOrderId().substring(4));
        unifiedOrderEntity.setMsgSrc(msgSrc);
        unifiedOrderEntity.setMsgType(unifiedOrderEntity.getMsgType());
        unifiedOrderEntity.setRequestTimestamp(DataUtil.getNowDate());
        Map<String, String> map = SerializableUtil.getObjectMap(unifiedOrderEntity, key);
        return UnionPayPostUtil.getPostAssemble(map, isTest ? UNIONPAY_UNIFIEDORDER_URI_TEST : UNIONPAY_UNIFIEDORDER_URI);
    }

//    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
//        UnifiedOrderEntity unifiedOrderEntity = new UnifiedOrderEntity();
//        unifiedOrderEntity.setInstMid("APPDEFAULT");
//        unifiedOrderEntity.setMerOrderId("3194201806141507531895266");
//        unifiedOrderEntity.setMid("898310148160568");
//        unifiedOrderEntity.setMsgSrc("WWW.TEST.COM");
//        unifiedOrderEntity.setMsgType("uac.appOrder");
//        unifiedOrderEntity.setRequestTimestamp(DataUtil.getNowDate());
//        unifiedOrderEntity.setTid("00000001");
//        unifiedOrderEntity.setTotalAmount(1);
//        Map<String, String> map = SerializableUtil.getObjectMap(unifiedOrderEntity, "12313");
//
////        SerializableUtil.getJsonString(unifiedOrderEntity);
//        JSONObject jsonObject = UnionPayPostUtil.getPostAssemble(map, UNIONPAY_UNIFIEDORDER_URI_TEST);
//        System.out.println("\n\n" + jsonObject + "\n\n");
//    }

    /**
     *  查询订单支付状态
     * @param unifiedOrderEntity 对象，传个订单号即可
     * @return
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public JSONObject postUnionPay_QueryPayStatus (UnifiedOrderEntity unifiedOrderEntity) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        unifiedOrderEntity.setMsgType("query");
        unifiedOrderEntity.setMsgSrc(msgSrc);
        unifiedOrderEntity.setRequestTimestamp(DataUtil.getNowDate());
        unifiedOrderEntity.setMid(mid);
        unifiedOrderEntity.setTid(tid);
        unifiedOrderEntity.setInstMid(instMid);
        Map<String, String> map = SerializableUtil.getObjectMap(unifiedOrderEntity, key);
        return UnionPayPostUtil.getPostAssemble(map, isTest ? UNIONPAY_QUERYPAYSTATUS_URI_TEST : UNIONPAY_QUERYPAYSTATUS_URI);
    }

}