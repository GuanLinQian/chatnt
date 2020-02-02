package club.chatnt.util;

import club.chatnt.entity.Groupmessage;
import com.google.gson.Gson;

/**
 * 时间:14:02
 * 作者：Maibenben
 **/
public class JsonUtil {

    private  static Gson gson;
    public static String ObjectToJson(Object obj){
         gson=new Gson();
        return gson.toJson(obj);
    }
   public static  Groupmessage JsonToGroupmessage(String json){
       gson=new Gson();
       return  gson.fromJson(json,Groupmessage.class);

   }
}
