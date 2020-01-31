package club.chatnt.returnjson;

import club.chatnt.entity.Nation;
import club.chatnt.entity.Province;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:14:50
 * 作者：Maibenben
 **/
public class ProvinceMapJson {
    private static Map map;

    public static Map returnInitProvinces(List<Province> provinces){
        map=new HashMap();
        map.put("provinces",provinces);
        return  map;
    }

}
