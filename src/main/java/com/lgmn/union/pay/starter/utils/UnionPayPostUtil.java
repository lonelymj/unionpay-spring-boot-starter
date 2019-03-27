package com.lgmn.union.pay.starter.utils;

import com.alibaba.fastjson.JSONObject;
import com.lgmn.union.pay.starter.domain.UnifiedOrderEntity;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
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
//
//    public static JSONObject getPostAssemble(String xml, String uri) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        String jsonStr=JSONObject.toJSONString(xml);
//        System.out.println(jsonStr);
//        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStr, httpHeaders);
//        JSONObject jsonObject = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, JSONObject.class).getBody();
//        return jsonObject;
//    }

    public static JSONObject getPostAssemble(String xml, String uri) {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        // 解决中文乱码
//        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
//        converterList.remove(1); // 移除原来的转换器
//        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
//        converterList.add(1, converter); // 添加新的转换器
//        restTemplate.setMessageConverters(converterList);
        List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }
        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converterList.add(converter);
        restTemplate.setMessageConverters(converterList);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_ATOM_XML);
        String jsonStr=JSONObject.toJSONString(xml);
        System.out.println(jsonStr);
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonStr, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);

        System.out.println("\n\n" + responseEntity.getBody() + "\n\n");
//        JSONObject jsonObject = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, JSONObject.class).getBody();
//        return jsonObject;

        return null;
    }

}
