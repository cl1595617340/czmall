package com.bdqn.springboot.service;

import com.bdqn.springboot.entity.Generalize;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-04
 */
public interface GeneralizeService extends IService<Generalize> {
    /*查询主页推广数据*/
    List<Generalize> f_GeneralizeList()throws Exception;
    /*--------------------------------后台方法 --* */
    /*根基专区id得到旗下的商品*/
    Generalize getGeneralizeById(Long ID)throws Exception;

    /*停用和启用专区*/
    int updateGeneralizeState(Long id,Integer state)throws Exception;
}
