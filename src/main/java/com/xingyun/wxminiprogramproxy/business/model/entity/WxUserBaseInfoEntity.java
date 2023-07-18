package com.xingyun.wxminiprogramproxy.business.model.entity;

import com.xingyun.wxminiprogramproxy.framework.model.constant.GlobalConstantValues;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 * api 接口用户
 * 微信小程序用户
 */
@Table(name = "t_wx_user_info")
@Entity
@Data
public class WxUserBaseInfoEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "SnowFlakeId")
    @GenericGenerator(name = "SnowFlakeId", strategy = GlobalConstantValues.SNOW_FLAKE_ID_GENERATOR_STRATEGY)
    @Column(name = "id")
    private Long id;
    /**
     * 用户唯一标识
     */
    @Column(name = "open_id")
    private String openId;
    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;
    /**
     * 城市
     */
    @Column(name = "city")
    private String city;
    /**
     * 省
     */
    @Column(name = "province")
    private String province;
    /**
     * 国家
     */
    @Column(name = "country")
    private String country;
    /**
     * 头像照片
     */
    @Column(name = "avatar_url")
    private String avatarUrl;
    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
     */
    @Column(name = "union_id")
    private String unionId;
    /**
     * 数据水印
     * timestamp 用户获取手机号操作的时间戳
     * appid 小程序 appid
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "water_mark",columnDefinition = "text")
    private String watermark;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "session_key",columnDefinition = "text")
    private String sessionKey;

    @Column(name = "wx_bind_phone_number")
    private String wxBindPhoneNumber;

    @Column(name = "token")
    private String token;
    /**
     * 启用状态  true 正常  false 禁用
     */
    @Column(name = "status")
    private Boolean status;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
    /**
     * 逻辑删除标记  true表示逻辑删除  false标识 正常未删除
     */
    @Column(name = "del_flag")
    private Boolean delFlag;
}
