package com.bdqn.springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.springboot.entity.Goodscolor;
import com.bdqn.springboot.entity.Versions;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 询查主列表有分页
     * @return
     * @throws Exception
     */
    IPage<Goods> getGoodsList(Page<Goods> page, Goods goods)throws Exception;

    List<Versions> getVersions(Integer id);

    List<Goodscolor> getGoodscolor(Integer id);
    /*批量下架商品*/
    int updateGodosState(Map<String,Object> map)throws Exception;

    /*子组件版本添加后根基goodsId刷新用的*/
    List<Versions> Versionslist(Long goodsId)throws Exception;

    /*子组件展示图添加后根基goodsId刷新用的*/
    List<Goodscolor> GoodscolorlistById(Long goodsId)throws Exception;
}
