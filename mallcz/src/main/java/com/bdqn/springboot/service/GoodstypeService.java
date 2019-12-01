package com.bdqn.springboot.service;

import com.bdqn.springboot.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.springboot.entity.Goodstype2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
public interface GoodstypeService extends IService<Goodstype> {

    /*3表查询分类信息*/
    List<Goodstype> getGoodstype()throws Exception;

    /*根据1级分类动态加载2级分类*/
    List<Goodstype2> getGoodstype2List(Integer id)throws Exception;

    /*根基2级分类id查询1级分类信息*/
    Goodstype getGoodstypeBy2(Integer id)throws Exception;


    /*根基3级分类id查询2级分类信息*/
    Goodstype2 getGoodstype2By3(Integer id)throws Exception;

    /*修改分类状态，他下面所有状态修改(id是表的外键，这里是修改2就分类的状态.state是修改的状态)*/
    int updateDescendantBy2(@Param("id") Long id,@Param("state") Integer state)throws Exception;

    /*修改分类状态，他下面所有状态修改(id是表的外键，这里是修改3级分类的状态.state是修改的状态)*/
    int updateDescendantBy3(@Param("id") Long id,@Param("state") Integer state)throws Exception;

    /*修改1级分类下所有的3级分类状态，要拿他所有2级分类的id，所以要用数组批量修改*/
    int updateType3AllDescendant(Map<String,Object> map)throws Exception;

    /*---------------------------------------------------------------------项目前台的接口----------*/
    /*没被禁用的1级分类，用redis*/
    String  getAllGoodsTypeByF()throws Exception;

    /*1级分类显示其下的所有分类信息,(id是1级分类的id)*/
    Goodstype getGoodstypeTo23ByF(Integer id)throws Exception;
}
