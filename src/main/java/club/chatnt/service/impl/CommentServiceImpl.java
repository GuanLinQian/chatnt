package club.chatnt.service.impl;

import club.chatnt.entity.Comment;
import club.chatnt.mapper.CommentMapper;
import club.chatnt.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
