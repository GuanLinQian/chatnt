package club.chatnt.returnjson;

import club.chatnt.entity.Article;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间:21:08
 * 作者：Maibenben
 **/
public class CommentMapJson {
    private static Map map;
    public static Map returnGetCom_User(Page page){
        map =new HashMap();
        map.put("pages",page.getPages());
        map.put("coms",page.getRecords());

        return  map;
    }

    public static  Map returnAddComment(boolean f){
        map =new HashMap();
        if(f){

            map.put("msg","发表评论成功！");
            map.put("sign",true);

        }else {
            map.put("msg","发表评论失败！");
            map.put("sign",false);
        }

return  map;

    }
}
