package club.chatnt.controller;


import club.chatnt.entity.Article;
import club.chatnt.entity.Comment;
import club.chatnt.entity.User;
import club.chatnt.returnjson.CommentMapJson;
import club.chatnt.service.CommentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
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
@RequestMapping("/comment")
public class CommentController {
@Autowired
    CommentService commentService;
@Autowired
    HttpServletRequest request;
@RequestMapping("getCom_User")
    public Map getCom_User(Integer page,Integer articleId){

    Page page1=commentService.getCom_User(new Page(page,2),articleId );

    return CommentMapJson.returnGetCom_User(page1);

}
@RequestMapping("addComment")
    public Map addComment(Comment comment){
    System.out.println(comment);
    User user=(User)request.getSession().getAttribute("user");
    comment.setCreateTime(LocalDateTime.now());
    comment.setUserId(user.getId());
 return CommentMapJson.returnAddComment(commentService.save(comment));

}
}

