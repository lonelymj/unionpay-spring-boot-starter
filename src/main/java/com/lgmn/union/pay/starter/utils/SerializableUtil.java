package com.lgmn.union.pay.starter.utils;


import com.alibaba.fastjson.JSONObject;
import com.lgmn.union.pay.starter.domain.UnifiedOrderEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SerializableUtil {

       public static Map<String, String> getObjectMap(UnifiedOrderEntity unifiedOrderEntity, String key) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = unifiedOrderEntity.getClass().getDeclaredFields();
        Class clazz = unifiedOrderEntity.getClass();
        Map<String, String> map = new LinkedHashMap();
        Map<String, String> multiValueMap = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            Object o = getMethod.invoke(unifiedOrderEntity);//执行get方法返回一个Object
            if (o != null) {
                map.put(fieldName, o.toString());
                multiValueMap.put(fieldName, o.toString());
            }
        }
        String peramStr = getParamStr(getSortedMap(map))+ key;
        String sign = MD5Util.getMD5Code(peramStr);
        multiValueMap.put("sign", sign);
        return multiValueMap;
    }

    public static void getJsonString(UnifiedOrderEntity unifiedOrderEntity, String key) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Field[] fields = unifiedOrderEntity.getClass().getDeclaredFields();
        Class clazz = unifiedOrderEntity.getClass();
        Map<String, String> map = new LinkedHashMap();
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            Object o = getMethod.invoke(unifiedOrderEntity);//执行get方法返回一个Object
            if (o != null) {
                map.put(fieldName, o.toString());
                multiValueMap.add(fieldName, o.toString());
            }
        }
        String peramStr = getParamStr(getSortedMap(map))+ key;
        String sign = MD5Util.getMD5Code(peramStr);
        unifiedOrderEntity.setSign(sign);
    }


    /**
     * Map 转String
     *
     * @param kv
     * @return
     */
    private static String getParamStr(Map<String, String> kv) {
        String result = kv.toString();
        result = result.replaceAll(", ", "&");
        result = result.replaceAll("\\{|\\}", "");
        return result;
    }

    private static Map<String, String> getSortedMap(Map<String, String> kv) {
        Map<String, String> result = new LinkedHashMap<>();
        List<String> fieldList = new ArrayList<>();
        Set<String> keys = kv.keySet();
        for (String key : keys) {
            fieldList.add(key);
        }
        Collections.sort(fieldList);
        for (String key : fieldList) {
            result.put(key, kv.get(key));
        }
        return result;
    }
}
