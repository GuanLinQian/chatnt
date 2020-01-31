package club.chatnt.controller;


import club.chatnt.entity.Province;
import club.chatnt.returnjson.ProvinceMapJson;
import club.chatnt.service.ProvinceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
 @RequestMapping("initProvinces")
    public Map initProvinces(Integer id){

     List<Province> provinces=provinceService.list(new QueryWrapper<Province>().eq("nationId",id));

     return ProvinceMapJson.returnInitProvinces(provinces);
 }


}

