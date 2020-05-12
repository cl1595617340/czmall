package com.bdqn.springboot.controller.front.type;


import com.alibaba.fastjson.JSON;
import com.bdqn.springboot.entity.Goodstype;
import com.bdqn.springboot.entity.Goodstype2;
import com.bdqn.springboot.entity.Goodstype3;
import com.bdqn.springboot.service.GoodstypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*项目前台的分类控制器
* */
@CrossOrigin
@RestController
@RequestMapping("/front/type/goodstype")
public class GoodsTypeController {

    @Resource
    private GoodstypeService goodstypeService;


    //从redis中华
    @RequestMapping("/getAllGoodsTypeByF")
    public String getAllGoodsTypeByF(){
        String GoodsTypeByF = null;
        try {
            GoodsTypeByF = goodstypeService.getAllGoodsTypeByF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GoodsTypeByF;
    }

    @RequestMapping("/getGoodstypeTo23ByF")
    public String getGoodstypeTo23ByF(Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            Goodstype goodstype = goodstypeService.getGoodstypeTo23ByF(id);
            List<Goodstype2> goodstype2List = goodstype.getGoodstype2();

            map.put("goodstype",goodstype);
        } catch (Exception e) {

        }
        return JSON.toJSONString(map);
    }
}
