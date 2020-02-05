package club.chatnt.service;

import club.chatnt.entity.Article;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public interface ArticleService extends IService<Article> {
    public Page getArticles_User(Page page);
    public List<Article> getArticles_UserTop();
     Page getArticles_UserInfor(Page page,Integer id);


}
