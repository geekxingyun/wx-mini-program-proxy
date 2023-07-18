package com.xingyun.wxminiprogramproxy.business.api;

import com.xingyun.wxminiprogramproxy.framework.model.vo.VueElementAdminResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author qingfeng.zhao
 * @date 2023/5/8
 * @apiNote
 */
@RestController
public class HomePageController {
    /**
     * 首页
     * @return 返回 JSON
     */
    @GetMapping(value = "/")
    public VueElementAdminResponseVO homePage(){
        VueElementAdminResponseVO vueElementAdminResponseVO=new VueElementAdminResponseVO();
        vueElementAdminResponseVO.setCode(20000);
        vueElementAdminResponseVO.setMessage("欢迎访问微信小程序-API代理服务");
        vueElementAdminResponseVO.setData(null);
        return vueElementAdminResponseVO;
    }
}
