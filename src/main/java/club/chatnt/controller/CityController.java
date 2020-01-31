package club.chatnt.controller;


import club.chatnt.entity.City;
import club.chatnt.entity.Province;
import club.chatnt.returnjson.CityMapJson;
import club.chatnt.service.CityService;
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
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping("initCitys")
    public Map initCitys(Integer id){
        List<City> citys=cityService.list(new QueryWrapper<City>().eq("provinceId",id));

return CityMapJson.returnInitCitys(citys);
    }

}

