package com.xingyun.wxminiprogramproxy.framework.model.vo;

import com.xingyun.wxminiprogramproxy.framework.util.SmartStringUtils;
import lombok.Data;

import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/7/18
 * @apiNote
 */
@Data
public class VueElementAdminResponseVO implements Serializable {
    private static final long serialVersionUID = -9186864023091351710L;
    private Integer code;
    private String message;
    private Object data;
    private String trackId = SmartStringUtils.generateSnowFakeIdStr();
}
