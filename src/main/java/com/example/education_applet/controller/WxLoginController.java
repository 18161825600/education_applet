package com.example.education_applet.controller;

import com.example.education_applet.common.EducationJsonResult;
import com.example.education_applet.model.WXSessionModel;
import com.example.education_applet.pojo.User;
import com.example.education_applet.service.UserService;
import com.example.education_applet.utils.HttpClientUtil;
import com.example.education_applet.utils.JsonUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序微信登录
 */
@Slf4j
@RestController
public class WxLoginController {


    @Autowired
    private UserService userService;

    @ApiOperation("微信登录接口")
    @PostMapping("/wxLogin")
    public EducationJsonResult wxLogin(String code) {
        System.out.println("wxlogin - code: " + code);
        log.debug("code",new Date()+"--codel->"+code);

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<>();
        //小程序id
        param.put("appid", "wx27a2536197bf0332");
        //微信秘钥
        param.put("secret", "a73eb3e52eeed1c3a8fd31cfb59aba02");
        param.put("js_code", code);
        //写死
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);

        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        String openid = model.getOpenid();
        log.debug("openid",new Date()+"--openid->"+openid);


        User userByOpenId = userService.userByOpenId(openid);
        if (userByOpenId!=null){
            Map map=new HashMap();
            if(userByOpenId.getUserPower()==0){
                map.put("power","普通用户");
            }else {
                map.put("power","主播");
            }
            map.put("end","登录成功");
            map.put("openid",openid);
            return EducationJsonResult.ok(map);
        }else {
            //没有该用户时直接在后台生成新的用户
            User user=new User();
            user.setOpenId(openid);
            //添加新用户
            userService.insertUser(user);
            Map map=new HashMap();
            map.put("end","登录成功,欢迎新用户");
            map.put("openid",openid);
            return EducationJsonResult.ok(map);
        }
    }
}
