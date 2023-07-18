package com.xingyun.wxminiprogramproxy.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author qing-feng.zhao
 * @description 静态资源处理
 * @date 2019/11/23 10:06
 */
@Component
@Configuration
public class StaticResourceConfig extends WebMvcConfigurationSupport {

    /**
     * 处理拦截的静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //自定义框架资源处理
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //Swagger 2静态资源处理
        registry.addResourceHandler("/swagger-ui**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/swagger-resources/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //Swagger 3 静态资源处理
        registry.addResourceHandler("/documentation/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/").resourceChain(false);
        registry.addResourceHandler("/csrf/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/MP_verify_oO9gqu9Pv8fY06o0.txt").addResourceLocations("classpath:/MP_verify_oO9gqu9Pv8fY06o0.txt");
        registry.addResourceHandler("/ZR0mFzgz0e.txt").addResourceLocations("classpath:/ZR0mFzgz0e.txt");
        registry.addResourceHandler("/apple-app-site-association").addResourceLocations("classpath:/apple-app-site-association");
    }
}
