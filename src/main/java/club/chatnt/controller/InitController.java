package club.chatnt.controller;


import club.chatnt.entity.*;
import club.chatnt.returnjson.InitMapJson;

import club.chatnt.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 时间:12:53
 * 作者：Maibenben
 **/
//用于初始化各页面
@RestController
@RequestMapping("/init")
public class InitController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    LinkService linkService;
    @Autowired
    SigninService signinService;
    @Autowired
    GroupdService groupdService;
@Autowired
    ArticleService articleService;
@Autowired
    NationService nationService;
@Autowired
  ProvinceService provinceService;
@Autowired
  CityService cityService;
    @RequestMapping("initIndex")
    public Map initIndex(){
        User user=(User)request.getSession().getAttribute("user");
        List<Link> links=linkService.list();
        Integer count=signinService.count(new QueryWrapper<Signin>().like("createTime","2020").eq("userId",user.getId()));
    return InitMapJson.returnInitIndex(user,links,count);
    }
    @RequestMapping("initChatSel")

    public Map initChatSel(){
        User user=(User)request.getSession().getAttribute("user");
        List<Groupd>groupds=groupdService.list();
return  InitMapJson.returnInitChatSel(user,groupds);
    }

    @RequestMapping("initTc")

    public  Map initTc(){
        User user=(User)request.getSession().getAttribute("user");
        return  InitMapJson.returnInitTc(user);
    }
    @RequestMapping("initPC")
    public  Map initPC(){
        User user=(User)request.getSession().getAttribute("user");
        List<Nation>nations=nationService.list();
        List<Province>provinces=provinceService.list();
        List<City>citys=cityService.list();
return  InitMapJson.returnInitPC(user,nations,provinces,citys);
    }
}
