package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.TAdmin;
import com.bdqn.springboot.dao.TAdminMapper;
import com.bdqn.springboot.service.TAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-26
 */
@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService {


    @Resource
    private TAdminMapper tAdminMapper;

    @Override
    public TAdmin getAdminByName(String name) throws Exception {
        return tAdminMapper.getAdminByName(name);
    }
}
