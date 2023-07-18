package com.xingyun.wxminiprogramproxy.business.service;

import com.xingyun.wxminiprogramproxy.business.model.dto.code2Session.WxMiniProgramLoginDTO;
import com.xingyun.wxminiprogramproxy.business.model.dto.getStableAccessToken.ApiCallAccessTokenDTO;
import com.xingyun.wxminiprogramproxy.business.model.dto.getphonenumber.FetchUserPhoneInfoDTO;

/***
 * @author qingfeng.zhao
 * @date 2023/7/18
 * @apiNote
 */
public interface WxMiniProgramInterfaceProxyService {
    /**
     * 小程序登陆-code2Session
     * @link https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-login/code2Session.html
     * 微信接口英文名:code2Session
     * @param js_code 登录时获取的 code，可通过wx.login获取
     * @return
     */
    WxMiniProgramLoginDTO code2Session(String js_code);
    /**
     * 获取手机号-getPhoneNumber
     * @link https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-info/phone-number/getPhoneNumber.html
     * @param code 手机号获取凭证
     * @return
     */
    FetchUserPhoneInfoDTO getPhoneNumber(String code);
    /**
     * 获取接口调用凭据-getAccessToken
     * @return
     */
    ApiCallAccessTokenDTO getAccessToken();
    /**
     * 获取稳定版接口调用凭据-getStableAccessToken
     * @return 获取到的接口凭证
     */
    ApiCallAccessTokenDTO getStableAccessToken();
}
