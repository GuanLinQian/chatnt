package club.chatnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 时间:15:38
 * 作者：Maibenben
 **/
@Controller
@RequestMapping("service")
public class FileController {

    @RequestMapping("{serviceName}")
    public  String  serviceName(@PathVariable("serviceName")String serviceName){
        return serviceName;
    }
}
