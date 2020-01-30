package club.chatnt.service;

import club.chatnt.entity.Mail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
public interface MailService extends IService<Mail> {

   void  simpleMail(Mail mail);
   void  htmlMail(Mail mail);
}
