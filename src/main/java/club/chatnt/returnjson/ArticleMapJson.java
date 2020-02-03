package club.chatnt.returnjson;

import club.chatnt.entity.Article;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:14:33
 * 作者：Maibenben
 **/
public class ArticleMapJson {
    private static Map map;
    public static Map returnGetArts_User(Page page, List<Article> articles){
        map =new HashMap();
        map.put("count",page.getTotal());
        map.put("arts",page.getRecords());
        map.put("tcTopAcrs",articles);
 return  map;
    }
    public static Map returnGetArtById(Article article){
        map =new HashMap();
        map.put("art",article);
        return  map;
    }
}
