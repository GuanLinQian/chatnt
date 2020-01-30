package club.chatnt.util;

import club.chatnt.entity.Mail;
import club.chatnt.entity.User;

import java.util.Date;

/**
 * 时间:19:26
 * 作者：Maibenben
 **/
public class MailTemplatesUtil {


    public static  String  htmlTemplate(User user,String newPassword){


        return "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n" +
                "<div class=\"box-content\" style=\"width: 80%; margin: 20px auto; max-width: 800px; min-width: 600px;\">\n" +
                "    <div class=\"header-tip\" style=\"font-size: 12px;\n" +
                "                                   color: #aaa;\n" +
                "                                   text-align: right;\n" +
                "                                   padding-right: 25px;\n" +
                "                                   padding-bottom: 10px;\">\n" +
                "        chatnt.club\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n" +
                "                                  border-bottom-right-radius: 10px;\n" +
                "                                  border:1px solid #ddd;\n" +
                "                                  overflow: hidden;\n" +
                "                                  padding: 15px 15px 20px;\">\n" +
                "        <div class=\"tips\" style=\"padding:15px;\">\n" +
                "            <p style=\" list-style: 160%; margin: 10px 0;\">尊敬的"+user.getNickName()+"你好:</p>\n" +
                "            <p style=\" list-style: 160%; margin: 10px 0;\">你已经找回密码，您的新密码为:"+newPassword+"请您及时修改！</p>\n" +
                "        </div>\n" +
                "        <div class=\"time\" style=\"text-align: right; color: #999; padding: 0 15px 15px;\">"+new Date().toLocaleString() +"</div>\n" +
                "        <br>\n" +
                "        <table class=\"list\" style=\"width: 100%; border-collapse: collapse; border-top:1px solid #eee; font-size:12px;\">\n" +
                "            <thead>\n" +
                "            <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;\">\n" +
                "        \n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n" +
                "          \n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>";
    }
}
