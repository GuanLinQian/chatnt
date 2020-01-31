package club.chatnt.returnjson;

import club.chatnt.entity.Mail;
import club.chatnt.entity.User;
import club.chatnt.service.MailService;
import club.chatnt.service.UserService;
import club.chatnt.util.MailTemplatesUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间:15:29
 * 作者：Maibenben
 **/
public class UserMapJson {
    private static Map map;
//登录
    public static Map returnLoginJson(User user, User userParam, HttpSession session){
        map=new HashMap<String,Object>();
        if(user==null){
            map.put("msg","该账户没有注册");
            map.put("sign",false);

        }
        else if(!user.getPassword().equals(DigestUtils.md5DigestAsHex(userParam.getPassword().getBytes()))){
            map.put("msg","密码错误，请核实在输入！");
            map.put("sign",false);

        }
        else if(user.getIsDisable()==0){
            map.put("msg","该账户已被封停！请联系管理员解封！");
            map.put("sign",false);
        }else {
           session.setAttribute("user",user);
            map.put("msg","登录成功");
            map.put("sign",true);
        }

return map;
    }

//找回密码
    public static   Map  returnRetrievePasswordJson(User user, UserService userService, MailService mailService){
        map=new HashMap<String,Object>();
        if(user==null){
            map.put("msg","该邮箱账户没有被注册");
            map.put("sign",false);

        }else if(user.getIsDisable()==0){
            map.put("msg","该账户已被封停！请联系管理员解封！");
            map.put("sign",false);
        }else {
            String newPassword= RandomStringUtils.random(9,true,false);
            Mail mail=new Mail();
            mail.setMsubject("找回密码");
            mail.setMfrom("chatnt@163.com");
            mail.setMto(user.getEmail());
            mail.setMcontent(MailTemplatesUtil.htmlTemplate(user,newPassword));
            mail.setMcreateTime(LocalDateTime.now());

            mailService.htmlMail(mail);
            System.out.println("设置前"+user);
            //重设密码
            user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
            System.out.println("设置后"+user);
            //修改
            userService.updateById(user);
            System.out.println("执行完修改"+user);
            map.put("msg","密码已发送到您的邮箱，请注意查收");
            map.put("sign",true);
        }

   return  map;

    }
    public  static Map returnRegisterJson(boolean  f){
        map=new HashMap<String,Object>();

        if(f){

            map.put("msg","注册成功！");
            map.put("sign",true);

        }else {
            map.put("msg","注册失败！");
            map.put("sign",false);
        }
return  map;
    }

}
