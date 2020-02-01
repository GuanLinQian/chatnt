package club.chatnt.returnjson;

import club.chatnt.entity.City;
import club.chatnt.entity.Link;
import club.chatnt.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:12:54
 * 作者：Maibenben
 **/
public class InitMapJson {
    private static Map map;

    public static Map returnInitIndex(User user, List<Link>links,Integer count){
        map=new HashMap();
       map.put("user",user);
       map.put("links",links);
       map.put("count",count);
        return  map;
    }
}
