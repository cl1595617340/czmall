package com.bdqn.springboot.service.impl;

import com.bdqn.springboot.entity.Phone;
import com.bdqn.springboot.dao.PhoneMapper;
import com.bdqn.springboot.service.PhoneService;
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
public class PhoneServiceImpl extends ServiceImpl<PhoneMapper, Phone> implements PhoneService {

}
