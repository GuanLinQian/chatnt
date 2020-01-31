package club.chatnt.controller;


import club.chatnt.entity.Nation;
import club.chatnt.returnjson.NationMapJson;
import club.chatnt.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lq
 * @since 2020-01-30
 */
@RestController
@RequestMapping("/nation")
public class NationController {
@Autowired
    NationService nationService;
@RequestMapping("initNations")

    public Map initNations(){
    List<Nation>  nations=nationService.list();

  return NationMapJson.returnInitNations(nations);

}
}

