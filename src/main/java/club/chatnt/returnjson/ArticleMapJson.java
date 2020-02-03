package club.chatnt.returnjson;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间:14:33
 * 作者：Maibenben
 **/
public class ArticleMapJson {
    private static Map map;
    public static Map returnGetArts_User(Page page){
        map =new HashMap();
        map.put("count",page.getTotal());
        map.put("arts",page.getRecords());
 return  map;
    }
}
