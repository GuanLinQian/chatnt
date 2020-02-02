package club.chatnt.websocket;

import club.chatnt.entity.Groupmessage;
import club.chatnt.entity.User;
import club.chatnt.service.GroupmessageService;
import club.chatnt.service.UserService;
import club.chatnt.util.JsonUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间:13:30
 * 作者：Maibenben
 **/
@Component
@ServerEndpoint("/javaChatRoom/{id}")
public class JavaChatRoom {
    // 这里使用静态，让 service 属于类
    private static GroupmessageService groupmessageService;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setGroupmessageService(GroupmessageService groupmessageService) {
        JavaChatRoom.groupmessageService = groupmessageService;
    }

    // 这里使用静态，让 service 属于类
    private static UserService userService;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setUserService(UserService userService) {
        JavaChatRoom.userService = userService;
    }

    /**
     * 在线人数
     */
    public static int onlineNumber = 0;

    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, Session> clients = new ConcurrentHashMap<>();
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户
     */
    private User user;



@OnOpen
    public void Onopen(@PathParam("id")Integer id,Session session){

     user=JavaChatRoom.userService.getOne(new QueryWrapper<User>().select("id","nickName","sex","headPortrait").eq("id",id));
     this.session=session;
     JavaChatRoom.onlineNumber++;
     clients.put(session.getId(),session);

    System.out.println("用户已连接--"+user.getNickName());

    Groupmessage groupmessage=new Groupmessage();
    groupmessage.setContent("用户"+user.getNickName()+"已加入java聊天室");
    groupmessage.setGroupId(1);
    groupmessage.setCreateTime(LocalDateTime.now());
    groupmessage.setUserId(id);
    sendAllForSys(groupmessage,user,0,JavaChatRoom.onlineNumber);

}
@OnMessage
    public void OnMessage(@PathParam("id")Integer id,String json,Session session){
        Groupmessage groupmessage=JsonUtil.JsonToGroupmessage(json);

        sendAll(groupmessage,user,1,JavaChatRoom.onlineNumber);
       groupmessage.setUserId(id);
       groupmessage.setGroupId(1);
       groupmessage.setCreateTime(LocalDateTime.now());
       groupmessageService.save(groupmessage);



    }

@OnClose

    public void OnClose(Session session,@PathParam("id")Integer id){
    System.out.println("关闭--------------"+user.getNickName());
    JavaChatRoom.onlineNumber--;
    Groupmessage groupmessage=new Groupmessage();
    groupmessage.setContent("用户"+user.getNickName()+"已离开java聊天室");
    groupmessage.setGroupId(1);
    groupmessage.setCreateTime(LocalDateTime.now());
    groupmessage.setUserId(id);
    sendAllForSys(groupmessage,user,0,JavaChatRoom.onlineNumber);




    clients.remove(session.getId());


}


    public void sendAllForSys(Groupmessage groupmessage,User user,Integer type,Integer count){
        Map<String,Object> map=new HashMap<>();
        map.put("gmsg",groupmessage);
        map.put("user",user);
        map.put("type",type);
        map.put("count",count);
        Collection<Session> sessions= clients.values();
        System.out.println(sessions.isEmpty());
        for(Session session:sessions){
            try {
                    if(this.session!=session) {
                        session.getBasicRemote().sendText(JsonUtil.ObjectToJson(map));
                    }

            }catch (IOException e){
                e.getMessage();
            }
        }



    }
public void sendAll(Groupmessage groupmessage,User user,Integer type,Integer count){
 Map<String,Object> map=new HashMap<>();
map.put("gmsg",groupmessage);
map.put("user",user);
map.put("type",type);
map.put("count",count);
Collection<Session> sessions= clients.values();

for(Session session:sessions){
    try {
        if(this.session!=session) {
            session.getBasicRemote().sendText(JsonUtil.ObjectToJson(map));
        }
    }catch (IOException e){
        e.getMessage();
    }
}



}

}
