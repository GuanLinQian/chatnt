package club.chatnt.controller;


import club.chatnt.entity.Article;
import club.chatnt.entity.Comment;
import club.chatnt.entity.User;
import club.chatnt.returnjson.ArticleMapJson;
import club.chatnt.service.ArticleService;
import club.chatnt.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
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
    @Autowired
    HttpServletRequest request;
    @Autowired
    CommentService commentService;
    @RequestMapping("getArts_User")

    public Map getArts_User(Integer page,Integer limit){
        System.out.println(page+limit);
        Page page1=articleService.getArticles_User(new Page(page,limit));
        List<Article> articles=articleService.getArticles_UserTop();
        return ArticleMapJson.returnGetArts_User(page1,articles);


    }
@RequestMapping("getArts_UserInfor")
public Map getArts_UserInfor(Integer page,Integer limit){
    User user=(User)request.getSession().getAttribute("user");
        Page page1=articleService.getArticles_UserInfor(new Page(page,limit),user.getId());
return ArticleMapJson.returnGetArts_UserInfor(page1);

}
@RequestMapping("getArtById")

    public Map getArtById(Integer id){
        Article article=articleService.getById(id);

        return  ArticleMapJson.returnGetArtById(article);


}
@RequestMapping("artAdd")
    public Map artAdd(Article article){
    User user=(User)request.getSession().getAttribute("user");
    article.setCreateTime(LocalDateTime.now());
    article.setIsScreen(1);
    article.setUserId(user.getId());
    System.out.println(user);
    boolean f=articleService.save(article);
    return  ArticleMapJson.returnArtAdd(f);

}
@RequestMapping("artDel")
    public Map artDel(Integer id){
        boolean f=articleService.removeById(id);
        commentService.remove(new QueryWrapper<Comment>().eq("articleId",id));
 return ArticleMapJson.returnArtDel(f);

}
}

