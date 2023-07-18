package com.xingyun.wxminiprogramproxy.business.model.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@ConfigurationProperties(prefix="com.ning.wx-mini-program")
@Data
public class WxMiniProgramProperties implements Serializable {
    private static final long serialVersionUID = -1379819017594701218L;
    private String appId;
    private String appSecret;
}
