package com.bdqn.springboot.service;

import com.bdqn.springboot.entity.Goodstype3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
public interface Goodstype3Service extends IService<Goodstype3> {

    /*主页的大模糊查询*/
    List<Goodstype3> f_getType3AndGoods(String name)throws Exception;
}
