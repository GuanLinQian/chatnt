package club.chatnt.service.impl;

import club.chatnt.entity.User;
import club.chatnt.mapper.UserMapper;
import club.chatnt.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
