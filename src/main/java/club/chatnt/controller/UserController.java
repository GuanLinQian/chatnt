package club.chatnt.controller;


import club.chatnt.entity.User;
import club.chatnt.returnjson.UserMapJson;
import club.chatnt.service.MailService;
import club.chatnt.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
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
@RequestMapping("register")

    public  Map register(User user){
    user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
    user.setCreateTime(LocalDateTime.now());
    user.setIsDisable(1);
    String loginId=RandomStringUtils.random(9,false,true);
    user.setLoginId(loginId);
    System.out.println(user);

    if(user.getSex().equals("男")) {
        user.setHeadPortrait("/upload/head/man.jpg");
    }else {
        user.setHeadPortrait("/upload/head/woman.jpg");
    }
return  UserMapJson.returnRegisterJson(userService.save(user), loginId);

}
@RequestMapping("upInfor")
    public Map upInfor(User user){
   boolean f= userService.updateById(user);
     User user1=userService.getById(user.getId());
     request.getSession().setAttribute("user",user1);
return  UserMapJson.returnUpInfor(f);
}
@RequestMapping("upPass")
    public  Map upPass(String oldPass,String newPass){
     User user=(User)request.getSession().getAttribute("user");
     Map<String,Object> map=new HashMap<>();

     if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(oldPass.getBytes()))){
         map.put("msg","旧密码输入错误！");
         map.put("sign",false);
     }else {
         request.getSession().removeAttribute("user");
         user.setPassword(DigestUtils.md5DigestAsHex(newPass.getBytes()));
         userService.updateById(user);
         map.put("msg","密码修改成功！");
         map.put("sign",true);
     }
return map;


}
@RequestMapping("loginOut")
    public  Map loginOut(){
    request.getSession().removeAttribute("user");
    Map<String,Object> map=new HashMap<>();
    map.put("msg","退出成功！");
   return map;

}
}

