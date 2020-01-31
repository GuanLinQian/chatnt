package club.chatnt.returnjson;

import club.chatnt.entity.City;
import club.chatnt.entity.Nation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:16:35
 * 作者：Maibenben
 **/
public class CityMapJson {
    private static Map map;

    public static Map returnInitCitys(List<City> citys){
        map=new HashMap();
        map.put("citys",citys);
        return  map;
    }

}
