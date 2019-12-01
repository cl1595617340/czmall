package com.bdqn.springboot.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.springboot.entity.Goodscolor;
import com.bdqn.springboot.entity.Versions;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 询查主列表有分页
     * @return
     * @throws Exception
     */
    IPage<Goods> getGoodsList(@Param("page") Page<Goods> page, @Param("goods") Goods goods)throws Exception;

    /*下面两个是为了拿分页数量的嵌套查询*/
    List<Versions> getVersions(Integer id);

    List<Goodscolor> getGoodscolor(Integer id);

    /*批量下架商品*/
    int updateGodosState(Map<String,Object> map)throws Exception;

    /*子组件版本添加后根基goodsId刷新用的*/
    List<Versions> Versionslist(Long goodsId)throws Exception;

    /*子组件展示图添加后根基goodsId刷新用的*/
    List<Goodscolor> GoodscolorlistById(Long goodsId)throws Exception;
}
