package com.xingyun.wxminiprogramproxy.business.model.dto.getphonenumber.item;

import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Data
public class WaterMarkDTO implements Serializable {
    private Long timestamp;
    private String appid;
}
