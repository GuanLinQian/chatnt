package club.chatnt.service.impl;

import club.chatnt.entity.Mail;
import club.chatnt.mapper.MailMapper;
import club.chatnt.service.MailService;
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
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements MailService {

}
