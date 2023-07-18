package com.xingyun.wxminiprogramproxy.framework.util;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
public class RestTemplateUtils {

    public static ClientHttpRequestFactory createSecureTransport() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000); // 5 seconds
        requestFactory.setReadTimeout(5000); // 5 seconds
        return requestFactory;
    }
    public RestTemplateUtils(){}
}
