package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.Goodstype3;
import com.bdqn.springboot.dao.Goodstype3Mapper;
import com.bdqn.springboot.service.Goodstype3Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
@Service
public class Goodstype3ServiceImpl extends ServiceImpl<Goodstype3Mapper, Goodstype3> implements Goodstype3Service {

    @Resource
    private Goodstype3Mapper goodstype3Mapper;

    @Override
    public List<Goodstype3> f_getType3AndGoods(String name) throws Exception {
        return goodstype3Mapper.f_getType3AndGoods(name);
    }
}
