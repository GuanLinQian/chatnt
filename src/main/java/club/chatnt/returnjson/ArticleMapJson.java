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
    public static  Map returnGetArts_UserInfor(Page page){
        map =new HashMap();
        map.put("count",page.getTotal());
        map.put("arts",page.getRecords());
        return  map;
    }
    public static Map returnGetArtById(Article article){
        map =new HashMap();
        map.put("art",article);
        return  map;
    }
    public static  Map returnArtAdd(boolean f){
        if(f){

            map.put("msg","发表文章成功！");
            map.put("sign",true);

        }else {
            map.put("msg","发表文章失败！");
            map.put("sign",false);
        }
        return  map;
    }
    public static Map returnArtDel(boolean f){
        if(f){

            map.put("msg","文章删除成功！");
            map.put("sign",true);

        }else {
            map.put("msg","文章删除失败！");
            map.put("sign",false);
        }
        return  map;
    }
}
