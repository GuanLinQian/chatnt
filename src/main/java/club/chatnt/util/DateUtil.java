package club.chatnt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间:19:49
 * 作者：Maibenben
 **/
public class DateUtil {

    public static void main(String[] args) {

        System.out.println(getDateToLocalString());

    }
    public static  String getDateToLocalString(){
        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
      return  simpleDateFormat.format(date);


    }

}
