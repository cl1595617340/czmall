package com.bdqn.springboot.dao;

import com.bdqn.springboot.entity.Generalize;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-04
 */
public interface GeneralizeMapper extends BaseMapper<Generalize> {

    /*查询主页推广数据*/
    List<Generalize> f_GeneralizeList()throws Exception;

    /*--------------------------------后台方法 --* */
    /*根基专区id得到旗下的商品*/
    Generalize getGeneralizeById(Long ID)throws Exception;

    /*停用和启用专区*/
    int updateGeneralizeState(@Param("id") Long id, @Param("state") Integer state)throws Exception;
}
