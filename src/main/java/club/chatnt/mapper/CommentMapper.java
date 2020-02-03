package club.chatnt.mapper;

import club.chatnt.entity.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getCom_User(Page page, @Param("articleId")Integer id);
}
