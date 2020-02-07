package club.chatnt.controller;

import club.chatnt.entity.User;
import club.chatnt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 时间:16:10
 * 作者：Maibenben
 **/
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    UserService userService;
@RequestMapping("uploadContentImg")
    public Map uploadContentImg(MultipartFile file){
        //父data
        Map<String,Object> map=new HashMap<>();
        //子data
        Map<String,Object> zmap=new HashMap<>();
        //获取文件后缀
        System.out.println(file.getOriginalFilename());
        String []hz=file.getOriginalFilename().split("\\.");
        String strs[]={"bmp","BMP","jpg","JPG","png","Png"};
        boolean f=false;//满足标志
        System.out.println(hz[0]);
        String filehz=hz[1];
    System.out.println(filehz);
    for(String s:strs){
        if(s.equals(filehz)){
            f=true;//有一个满足就是合法后缀

        }
    }
        if(!f)
        {
            map.put("code",1);
            map.put("msg","请选择bmp/jpg/png格式的图片！");
        }else {
            String path = "C:\\Program Files\\chatnt\\content\\";
            String fileName = UUID.randomUUID() + "." + filehz;
            System.out.println(fileName);
            File file1 = new File(path + fileName);

            if (file.isEmpty()) {
                map.put("msg", "文件为空！！");
                return map;
            }
            try {
                file.transferTo(file1);

            } catch (Exception e) {
                e.getMessage();
            }
            zmap.put("src", "/upload/content/" + fileName);

            map.put("data", zmap);
            map.put("code", 0);
            map.put("msg", "图片插入成功！");
        }
        return  map;
    }
    @RequestMapping("uploadHeadImg")
    public Map uploadHeadImg(MultipartFile file){
        //data
        Map<String,Object> map=new HashMap<>();
        User user=(User)request.getSession().getAttribute("user");
        //获取文件后缀
        System.out.println(file.getOriginalFilename());
        String []hz=file.getOriginalFilename().split("\\.");

        System.out.println(hz[0]);
        String filehz=hz[1];
        System.out.println(filehz);
            String path = "C:\\Program Files\\chatnt\\head\\";
            String fileName = UUID.randomUUID() + "." + filehz;
            System.out.println(fileName);
            File file1 = new File(path + fileName);

            if (file.isEmpty()) {
                map.put("msg", "文件为空！！");

            }
            try {

                file.transferTo(file1);

                user.setHeadPortrait("/upload/head/"+fileName);



            } catch (Exception e) {
                e.getMessage();
            }
        userService.updateById(user);
        map.put("msg","头像修改成功！");
        map.put("sign",true);



        return  map;


    }
}
