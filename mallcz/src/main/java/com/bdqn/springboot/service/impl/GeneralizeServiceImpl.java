package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.Generalize;
import com.bdqn.springboot.dao.GeneralizeMapper;
import com.bdqn.springboot.service.GeneralizeService;
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
 * @since 2020-01-04
 */
@Service
public class GeneralizeServiceImpl extends ServiceImpl<GeneralizeMapper, Generalize> implements GeneralizeService {


    @Resource
    private GeneralizeMapper generalizeMapper;

    @Override
    public List<Generalize> f_GeneralizeList() throws Exception {
        return generalizeMapper.f_GeneralizeList();
    }

    @Override
    public Generalize getGeneralizeById(Long ID) throws Exception {
        return generalizeMapper.getGeneralizeById(ID);
    }

    @Override
    public int updateGeneralizeState(Long id, Integer state) throws Exception {
        return generalizeMapper.updateGeneralizeState(id,state);
    }
}
