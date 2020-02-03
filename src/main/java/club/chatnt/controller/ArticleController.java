package club.chatnt.controller;


import club.chatnt.entity.Article;
import club.chatnt.returnjson.ArticleMapJson;
import club.chatnt.service.ArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @RequestMapping("getArts_User")

    public Map getArts_User(Integer page,Integer limit){
        System.out.println(page+limit);
        Page page1=articleService.getArticles_User(new Page(page,limit));
        List<Article> articles=articleService.getArticles_UserTop();
        return ArticleMapJson.returnGetArts_User(page1,articles);


    }
@RequestMapping("getArtById")

    public Map getArtById(Integer id){
        Article article=articleService.getById(id);

        return  ArticleMapJson.returnGetArtById(article);


}

}

