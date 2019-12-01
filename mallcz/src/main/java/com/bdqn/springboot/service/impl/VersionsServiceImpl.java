package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.Versions;
import com.bdqn.springboot.dao.VersionsMapper;
import com.bdqn.springboot.service.VersionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author KazuGin
 * @since 2019-11-28
 */
@Service
public class VersionsServiceImpl extends ServiceImpl<VersionsMapper, Versions> implements VersionsService {

}
