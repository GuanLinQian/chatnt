package club.chatnt.returnjson;

import club.chatnt.entity.Nation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:14:13
 * 作者：Maibenben
 **/
public class NationMapJson {
    private static Map map;

    public static Map returnInitNations(List<Nation> nations){
         map=new HashMap();
          map.put("nations",nations);
         return  map;
    }

}
