package com.xingyun.wxminiprogramproxy.business.model.vo;

import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/20
 * @apiNote
 */
@Data
public class WxUserInfoVO implements Serializable {
    private static final long serialVersionUID = 9058393393966497056L;

    private String id;

    private String unionId;
    private String openId;
    private String nickName;

    private String wxBindPhoneNumber;

    private String createDateTime;
    private String updateDateTime;

    private String loginToken;

    private Boolean status;
}
