package com.lgmn.union.pay.starter.utils;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.union.pay.starter.domain.UnifiedOrderEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class UnionPayPostUtil {

    /**
     * 发送 POST 请求并解析结果
     *
     * @param map 请求参数
     * @param uri 请求链接
     * @return
     */
    public static JSONObject getPostAssemble(Map<String, String> map, String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String jsonStr=JSONObject.toJSONString(map);
        System.out.println(jsonStr);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStr, httpHeaders);
        JSONObject jsonObject = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, JSONObject.class).getBody();
        return jsonObject;
    }

    public static JSONObject getPostAssemble(UnifiedOrderEntity unifiedOrderEntity, String uri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String jsonStr=JSONObject.toJSONString(unifiedOrderEntity);
        System.out.println(jsonStr);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStr, httpHeaders);
        JSONObject jsonObject = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, JSONObject.class).getBody();
        return jsonObject;
    }

}
