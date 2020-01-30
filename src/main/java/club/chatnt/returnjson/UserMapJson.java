package club.chatnt.returnjson;

import club.chatnt.entity.User;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间:15:29
 * 作者：Maibenben
 **/
public class UserMapJson {
    private static Map map;

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

}
