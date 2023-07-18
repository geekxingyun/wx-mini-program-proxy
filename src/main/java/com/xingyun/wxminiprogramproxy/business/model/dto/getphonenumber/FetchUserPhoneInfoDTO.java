package com.xingyun.wxminiprogramproxy.business.model.dto.getphonenumber;

import com.xingyun.wxminiprogramproxy.business.model.dto.getphonenumber.item.WxUserPhoneInfoDTO;
import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Data
public class FetchUserPhoneInfoDTO implements Serializable {
    private Integer errcode;
    private String errmsg;
    private WxUserPhoneInfoDTO phone_info;
}
