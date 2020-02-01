package club.chatnt.returnjson;

import club.chatnt.entity.Signin;
import club.chatnt.entity.User;
import club.chatnt.service.SigninService;
import club.chatnt.util.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间:20:02
 * 作者：Maibenben
 **/
public class SigninMapJson {
    private static Map map;
    public static  Map returnUserSign(SigninService signinService, HttpSession session){
        map=new HashMap();
        User user=(User)session.getAttribute("user");
        Signin signin=new Signin();
        signin.setFlag("1");
        signin.setCreateTime(LocalDateTime.now());
        signin.setUserId(user.getId());
        Integer i=signinService.count(new QueryWrapper<Signin>().like("createTime", DateUtil.getDateToLocalString()).eq("userId",user.getId()));
        if(i==0){
            signinService.save(signin);
            map.put("msg","签到成功！");
            map.put("sign",true);
        }else {
            map.put("msg","你今天已经签到过了，请勿重复签到！");
            map.put("sign",false);
        }
        return map;

    }
}
