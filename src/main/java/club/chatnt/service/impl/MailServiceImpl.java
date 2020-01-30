package club.chatnt.service.impl;

import club.chatnt.entity.Mail;
import club.chatnt.mapper.MailMapper;
import club.chatnt.service.MailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

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

    @Autowired
   private   JavaMailSender jms;
    @Override
    public void simpleMail(Mail mail) {
       //初始化简单邮件
        SimpleMailMessage message=new SimpleMailMessage();
        //发送者
         message.setFrom(mail.getMfrom());
         //接收者
        message.setTo(mail.getMto());
        //内容
        message.setText(mail.getMcontent());
        //标题
        message.setSubject(mail.getMsubject());
        //发送
        jms.send(message);

        this.baseMapper.insert(mail);


    }

    @Override
    public void htmlMail(Mail mail) {
        MimeMessage message=jms.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发送者
            helper.setFrom(mail.getMfrom());
            //接收者
            helper.setTo(mail.getMto());
            //主题
            helper.setSubject(mail.getMsubject());

            //内容
            helper.setText(mail.getMcontent(), true);
        }catch (Exception e){
            System.out.println("----邮件发送失败！");
            e.getMessage();
        }
        jms.send(message);
        this.baseMapper.insert(mail);



    }
}
