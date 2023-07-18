package com.xingyun.wxminiprogramproxy.business.service.impl;

import com.xingyun.wxminiprogramproxy.business.model.dto.code2Session.WxMiniProgramLoginDTO;
import com.xingyun.wxminiprogramproxy.business.model.dto.getStableAccessToken.ApiCallAccessTokenDTO;
import com.xingyun.wxminiprogramproxy.business.model.dto.getphonenumber.FetchUserPhoneInfoDTO;
import com.xingyun.wxminiprogramproxy.business.model.properties.WxMiniProgramProperties;
import com.xingyun.wxminiprogramproxy.business.service.WxMiniProgramInterfaceProxyService;
import com.xingyun.wxminiprogramproxy.framework.util.RestTemplateUtils;
import com.xingyun.wxminiprogramproxy.framework.util.SmartJackSonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote
 */
@Slf4j
@Service
public class WxMiniProgramInterfaceProxyServiceImpl implements WxMiniProgramInterfaceProxyService {

    final HttpHeaders httpHeaders;
    final WxMiniProgramProperties wxMiniProgramProperties;

    public WxMiniProgramInterfaceProxyServiceImpl(HttpHeaders httpHeaders, WxMiniProgramProperties wxMiniProgramProperties) {
        this.httpHeaders = httpHeaders;
        this.wxMiniProgramProperties = wxMiniProgramProperties;
    }

    /**
     * https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-login/code2Session.html
     * @param js_code 登录时获取的 code，可通过wx.login获取
     * @return
     */
    @Override
    public WxMiniProgramLoginDTO code2Session(String js_code) {
        String apiUrl = "https://api.weixin.qq.com/sns/jscode2session" + "?appid=" +
                wxMiniProgramProperties.getAppId() +
                "&secret=" +
                wxMiniProgramProperties.getAppSecret() +
                "&js_code=" +
                js_code +
                "&grant_type=" +
                "authorization_code";
        RestTemplate restTemplate = new RestTemplate(RestTemplateUtils.createSecureTransport());
        HttpEntity<String> entity = new HttpEntity<>(null,null);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info("微信小程序授权登录返回结果:{}",response.getBody());
        return SmartJackSonUtils.readValueToObject(response.getBody(), WxMiniProgramLoginDTO.class);
    }

    @Override
    public FetchUserPhoneInfoDTO getPhoneNumber(String code) {
        StringBuilder apiUrl=new StringBuilder("https://api.weixin.qq.com/wxa/business/getuserphonenumber");
        apiUrl.append("?access_token=");
        apiUrl.append(getStableAccessToken());
        // 设置请求参数
        HashMap<String,Object> paramMap = new LinkedHashMap<>();
        paramMap.put("code",code);
        // 发送 POST 请求并解析响应
        RestTemplate restTemplate = new RestTemplate(RestTemplateUtils.createSecureTransport());
        HttpEntity<String> entity = new HttpEntity<>(SmartJackSonUtils.writeObjectToJSon(paramMap), httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl.toString(),
                HttpMethod.POST,
                entity,
                String.class
        );
        return SmartJackSonUtils.readValueToObject(response.getBody(),FetchUserPhoneInfoDTO.class);
    }

    @Override
    public ApiCallAccessTokenDTO getAccessToken() {
        StringBuilder apiUrl=new StringBuilder("https://api.weixin.qq.com/cgi-bin/token");
        // 设置请求参数
        HashMap<String,Object> paramMap = new LinkedHashMap<>();
        // 填写 client_credential
        paramMap.put("grant_type","client_credential");
        // 账号唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得。（需要已经成为开发者，且帐号没有异常状态）
        paramMap.put("appid",wxMiniProgramProperties.getAppId());
        // 帐号唯一凭证密钥，即 AppSecret，获取方式同 appid
        paramMap.put("secret",wxMiniProgramProperties.getAppSecret());
        // 发送 POST 请求并解析响应
        RestTemplate restTemplate = new RestTemplate(RestTemplateUtils.createSecureTransport());
        HttpEntity<String> entity = new HttpEntity<>(SmartJackSonUtils.writeObjectToJSon(paramMap), httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl.toString(),
                HttpMethod.POST,
                entity,
                String.class
        );
        return SmartJackSonUtils.readValueToObject(response.getBody(), ApiCallAccessTokenDTO.class);
    }

    @Override
    public ApiCallAccessTokenDTO getStableAccessToken() {
        StringBuilder apiUrl=new StringBuilder("https://api.weixin.qq.com/cgi-bin/stable_token");
        // 设置请求参数
        HashMap<String,Object> paramMap = new LinkedHashMap<>();
        // 填写 client_credential
        paramMap.put("grant_type","client_credential");
        // 账号唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得。（需要已经成为开发者，且帐号没有异常状态）
        paramMap.put("appid",wxMiniProgramProperties.getAppId());
        // 帐号唯一凭证密钥，即 AppSecret，获取方式同 appid
        paramMap.put("secret",wxMiniProgramProperties.getAppSecret());
        // 默认使用 false。
        // 1. force_refresh = false 时为普通调用模式，access_token 有效期内重复调用该接口不会更新 access_token；
        // 2. 当force_refresh = true 时为强制刷新模式，会导致上次获取的 access_token 失效，并返回新的 access_token
        paramMap.put("force_refresh",false);
        // 发送 POST 请求并解析响应
        RestTemplate restTemplate = new RestTemplate(RestTemplateUtils.createSecureTransport());
        HttpEntity<String> entity = new HttpEntity<>(SmartJackSonUtils.writeObjectToJSon(paramMap), httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl.toString(),
                HttpMethod.POST,
                entity,
                String.class
        );
        return SmartJackSonUtils.readValueToObject(response.getBody(), ApiCallAccessTokenDTO.class);
    }
}
