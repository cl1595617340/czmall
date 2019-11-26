package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.Goodstype;
import com.bdqn.springboot.dao.GoodstypeMapper;
import com.bdqn.springboot.entity.Goodstype2;
import com.bdqn.springboot.service.GoodstypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-24
 */
@Service
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {


    @Resource
    private GoodstypeMapper goodstypeMapper;


    @Override
    public List<Goodstype> getGoodstype() throws Exception {
        return goodstypeMapper.getGoodstype();
    }

    @Override
    public List<Goodstype2> getGoodstype2List(Integer id) throws Exception {
        return goodstypeMapper.getGoodstype2List(id);
    }

    @Override
    public Goodstype getGoodstypeBy2(Integer id) throws Exception {
        return goodstypeMapper.getGoodstypeBy2(id);
    }

    @Override
    public Goodstype2 getGoodstype2By3(Integer id) throws Exception {
        return goodstypeMapper.getGoodstype2By3(id);
    }

    @Override
    public int updateDescendantBy2(Long id, Integer state) throws Exception {
        return goodstypeMapper.updateDescendantBy2(id,state);
    }

    @Override
    public int updateDescendantBy3(Long id, Integer state) throws Exception {
        return goodstypeMapper.updateDescendantBy3(id,state);
    }

    @Override
    public int updateType3AllDescendant(Map<String, Object> map) throws Exception {
        return goodstypeMapper.updateType3AllDescendant(map);
    }






}
