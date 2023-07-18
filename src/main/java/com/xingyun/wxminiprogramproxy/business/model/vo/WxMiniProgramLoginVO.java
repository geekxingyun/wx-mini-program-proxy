package com.xingyun.wxminiprogramproxy.business.model.vo;

import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Data
public class WxMiniProgramLoginVO implements Serializable {
    private static final long serialVersionUID = -2530453268018970432L;
    private String  token;
}
