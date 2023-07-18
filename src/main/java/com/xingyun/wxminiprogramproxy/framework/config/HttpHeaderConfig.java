package com.xingyun.wxminiprogramproxy.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/***
 * @author qingfeng.zhao
 * @date 2023/5/7
 * @apiNote
 */
@Configuration
public class HttpHeaderConfig {
    /**
     * 统一配置header
     * @return
     */
    @Bean
    public HttpHeaders httpHeaders(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }
}
