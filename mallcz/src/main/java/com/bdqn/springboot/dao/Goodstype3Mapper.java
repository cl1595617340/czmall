package com.bdqn.springboot.dao;

import com.bdqn.springboot.entity.Goodstype3;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
public interface Goodstype3Mapper extends BaseMapper<Goodstype3> {

    /*主页的大模糊查询*/
    List<Goodstype3> f_getType3AndGoods(@Param("name") String name)throws Exception;
}
