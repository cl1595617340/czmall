package com.bdqn.springboot.dao;

import com.bdqn.springboot.entity.TAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-26
 */
public interface TAdminMapper extends BaseMapper<TAdmin> {

    /*根基管理员名查询管理员*/
    TAdmin getAdminByName(@Param("name") String name)throws Exception;

}
