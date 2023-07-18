package com.xingyun.wxminiprogramproxy.framework.config;

import com.xingyun.wxminiprogramproxy.business.model.properties.WxMiniProgramProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/***
 * @author qingfeng.zhao
 * @date 2023/5/7
 * @apiNote
 */
@EnableConfigurationProperties({
        WxMiniProgramProperties.class
})
@Configuration
public class CustomPropertiesConfig {
}
