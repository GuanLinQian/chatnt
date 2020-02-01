package club.chatnt.controller;


import club.chatnt.returnjson.SigninMapJson;
import club.chatnt.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/signin")
public class SigninController {
    @Autowired
    SigninService signinService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("userSign")
    public Map userSign(){

     return SigninMapJson.returnUserSign(signinService,request.getSession());
    }

}

