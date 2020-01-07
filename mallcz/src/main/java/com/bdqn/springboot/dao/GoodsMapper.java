package com.bdqn.springboot.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.springboot.entity.Goodscolor;
import com.bdqn.springboot.entity.Versions;
import com.bdqn.springboot.entity.queryList.QueryList;
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


    /*点击一级分类显示旗下的所有手机*/
    List<Goods> f_typeGoods(Integer id)throws Exception;

    /*-------------------------前端的商品接口方法-------------*/

    /*主页分类显示所有手机*/
    List<Goods> f_getGoodsListToType(QueryList queryList)throws Exception;

    /*下面是1对多的接口方法*/
    /*1,查出分页数量的物品id*/
    List<Goods> page_getGoodsID(@Param("statrPage") Integer statrPage,@Param("endPage") Integer endPage)throws Exception;

    /*2,查出物品完整连表的数据条数,根据分页数量计算--(物品的总数)--,物品id是由步骤1得来的*/
    Integer page_getGoodsSum(Integer id)throws Exception;

    /*主页的大模糊查询*/
    List<Goods> f_likeGetGoods(@Param("name") String name,@Param("type") String type)throws Exception;

    /*主页的大模糊查询取反，主要查询除了手机分类的数据*/
    List<Goods> f_likeGetGoodsNot(@Param("name") String name,@Param("type") String type)throws Exception;

    /*4表查询手机的参数信息*/
    Goods f_getParameterinfo(Long id)throws Exception;

}
