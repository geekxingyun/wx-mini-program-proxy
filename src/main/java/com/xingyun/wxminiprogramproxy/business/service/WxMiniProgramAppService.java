package com.xingyun.wxminiprogramproxy.business.service;

import com.xingyun.wxminiprogramproxy.business.model.entity.WxUserBaseInfoEntity;
import com.xingyun.wxminiprogramproxy.business.model.vo.WxUserInfoVO;
import com.xingyun.wxminiprogramproxy.framework.model.vo.VueElementAdminResponseVO;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote 微信小程序 接口服务
 */
public interface WxMiniProgramAppService {
    /**
     * 微信小程序登陆接口
     * @param code 微信小程序通过 wx.login() 方法获取到的 code
     * @return 返回登录的 token
     */
    VueElementAdminResponseVO wxMiniProgramLogin(String code);
    /**
     * 微信小程序登录参数校验接口
     * @param code  微信小程序通过 wx.login() 方法获取到的 code
     * @return 返回参数校验结果
     */
    VueElementAdminResponseVO checkWxMiniProgramLoginParam(String code);
    /**
     * 检查是否是否登录 且 token有效
     * @param token 待检查的token
     * @return 返回是否已登录并且 token 有效
     */
    VueElementAdminResponseVO checkWxMiniProgramLogin(String token);
    /**
     * 根据 token 获取用户信息
     * @param token 登录用户 token
     * @return 微信用户信息
     */
    VueElementAdminResponseVO fetchWxUserInfo(String token);
    /**
     * 对象转化
     * @param wxUserBaseInfoEntity 持久化存储对象
     * @return 返回页面用户信息 VO对象
     */
    WxUserInfoVO convertToWxMiniProgramCustomerVO(WxUserBaseInfoEntity wxUserBaseInfoEntity);
}
