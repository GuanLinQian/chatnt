package club.chatnt.service.impl;

import club.chatnt.entity.Group;
import club.chatnt.mapper.GroupMapper;
import club.chatnt.service.GroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

}
