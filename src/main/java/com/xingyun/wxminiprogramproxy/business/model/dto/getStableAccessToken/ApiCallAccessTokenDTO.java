package com.xingyun.wxminiprogramproxy.business.model.dto.getStableAccessToken;

import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Data
public class ApiCallAccessTokenDTO implements Serializable {
    private String access_token;
    private Integer expires_in;
}
