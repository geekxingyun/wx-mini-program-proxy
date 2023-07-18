package com.xingyun.wxminiprogramproxy.business.api;

import com.xingyun.wxminiprogramproxy.business.service.WxMiniProgramAppService;
import com.xingyun.wxminiprogramproxy.framework.model.vo.VueElementAdminResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author qingfeng.zhao
 * @date 2023/5/19
 * @apiNote 微信小程序相关接口
 */
@RequestMapping(value = "/wxMiniProgramAppService")
@RestController
public class WxMiniProgramEndPoint {

    final WxMiniProgramAppService wxMiniProgramAppService;

    public WxMiniProgramEndPoint(WxMiniProgramAppService wxMiniProgramAppService) {
        this.wxMiniProgramAppService = wxMiniProgramAppService;
    }

    /***
     * 检查微信用户登录状态
     * @param token 用户 token
     * @return 返回用户是否登录  true 有效登录  false 无效登录
     */
    @PostMapping(value = "/checkWxMiniProgramLogin.do")
    public VueElementAdminResponseVO checkWxMiniProgramLogin(String token){
        return wxMiniProgramAppService.checkWxMiniProgramLogin(token);
    }

    /**
     * 微信用户登录
     * @param code 微信用户登录请求 code
     * @return 返回登录用户 token
     */
    @PostMapping(value = "/wxMiniProgramLogin.do")
    public VueElementAdminResponseVO wxMiniProgramLogin(@RequestParam(value = "code")String code){
        return wxMiniProgramAppService.wxMiniProgramLogin(code);
    }

    /***
     * 根据登录用户 token 获取微信用户信息
     * @param token 微信用户登录成功的 token
     * @return 返回微信用户信息
     */
    @PostMapping(value = "/fetchWxUserInfo.do")
    public VueElementAdminResponseVO fetchWxUserInfo(String token){
        return wxMiniProgramAppService.fetchWxUserInfo(token);
    }
}
