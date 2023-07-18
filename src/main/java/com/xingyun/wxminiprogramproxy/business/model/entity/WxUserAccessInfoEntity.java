package com.xingyun.wxminiprogramproxy.business.model.entity;

import com.xingyun.wxminiprogramproxy.framework.model.constant.GlobalConstantValues;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/***
 * @author qingfeng.zhao
 * @date 2023/6/21
 * @apiNote 微信用户权限信息表
 */
@Data
public class WxUserAccessInfoEntity implements Serializable {
    private static final long serialVersionUID = -6247055853139587811L;
    @Id
    @GeneratedValue(generator = "SnowFlakeId")
    @GenericGenerator(name = "SnowFlakeId", strategy = GlobalConstantValues.SNOW_FLAKE_ID_GENERATOR_STRATEGY)
    @Column(name = "id")
    private Long id;
    @Column(name = "wxUserBaseInfoId")
    private Long wxUserBaseInfoId;
    @Column(name = "limit_flag")
    private Boolean limitFlag;
    @Column(name = "max_request_count")
    private Long maxRequestCount;
    @Column(name = "max_tokens")
    private Long maxTokens;
    @Column(name = "limit_type")
    private Integer limitType;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "interfaceListJson",columnDefinition = "text")
    private String interfaceListJson;
}
