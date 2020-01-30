package club.chatnt.controller;


import club.chatnt.entity.User;
import club.chatnt.returnjson.UserMapJson;
import club.chatnt.service.MailService;
import club.chatnt.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("/user")
public class UserController {
@Autowired
    UserService userService;

@Autowired
    HttpServletRequest request;


@Autowired
    MailService mailService;
@RequestMapping("login")

    public Map login(User userParam){
    User user=userService.getOne(new QueryWrapper<User>().eq("loginId",userParam.getLoginId()));


    return UserMapJson.returnLoginJson(user,userParam,request.getSession());


}

@RequestMapping("retrievePassword")
    public Map retrievePassword(String email){
User user=userService.getOne(new QueryWrapper<User>().eq("email",email));

 return  UserMapJson.returnRetrievePasswordJson(user,userService,mailService);

}
}

