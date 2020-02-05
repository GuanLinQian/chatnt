package club.chatnt.mapper;

import club.chatnt.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public interface ArticleMapper extends BaseMapper<Article> {

 List<Article> getArticles_User(Page page);
 List<Article> getArticles_UserTop();
 List<Article> getArticles_UserInfor(Page page, @Param("id")Integer id);
}
