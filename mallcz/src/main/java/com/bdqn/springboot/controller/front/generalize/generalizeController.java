package com.bdqn.springboot.controller.front.generalize;

import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Generalize;
import com.bdqn.springboot.service.GeneralizeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/front/generalize/generalize")
public class generalizeController {

    @Resource
    private GeneralizeService generalizeService;


    /*查询主页推广数据*/
    @RequestMapping("/f_GeneralizeList")
    public String f_GeneralizeList(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Generalize> generalizeslist = generalizeService.f_GeneralizeList();
            map.put("res",generalizeslist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
