package com.xingyun.wxminiprogramproxy.business.model.dto.code2Session;

import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Data
public class WxMiniProgramLoginDTO implements Serializable {
    private static final long serialVersionUID = -3615595541398611390L;
    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
     */
    private String unionid;
    /**
     * 错误信息
     */
    private String errmsg;
    /**
     * 错误码
     */
    private Integer errcode;
}
