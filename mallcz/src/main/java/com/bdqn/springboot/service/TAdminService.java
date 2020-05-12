package com.bdqn.springboot.service;

import com.bdqn.springboot.entity.TAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-26
 */
public interface TAdminService extends IService<TAdmin> {


    /*根基管理员名查询管理员*/
    TAdmin getAdminByName(String name)throws Exception;
}
