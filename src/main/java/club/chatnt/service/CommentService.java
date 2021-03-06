package club.chatnt.service;

import club.chatnt.entity.Comment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public interface CommentService extends IService<Comment> {

    public Page getCom_User(Page page,Integer articleId);
}
