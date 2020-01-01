package com.bdqn.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.springboot.dao.MemberMapper;
import com.bdqn.springboot.entity.Address;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public Member f_getMemByName(String name) throws Exception {
        return memberMapper.f_getMemByName(name);
    }

    @Override
    public Member f_loginmem(String ipone, String pwd) throws Exception {
        Member member = memberMapper.f_loginmem(ipone);
        if (member!=null){
            if (pwd.equals(member.getMemberpwd())){
                return member;
            }
        }
        return null;
    }

    @Override
    public Member f_getMemIdByavatar(String avater) throws Exception {
        return memberMapper.f_getMemIdByavatar(avater);
    }

    @Override
    public Member f_memAddressBuId(Integer id) throws Exception {
        return memberMapper.f_memAddressBuId(id);
    }

    /**
     * 询查主会员列表有一对多分页
     *
     * @param page
     * @param member
     * @return
     * @throws Exception
     */
    @Override
    public IPage<Member> getMemberList(Page<Member> page, Member member) throws Exception {
        return memberMapper.getMemberList(page,member);
    }

    @Override
    public int updateMemberState(Long id, Integer state) throws Exception {
        return memberMapper.updateMemberState(id,state);
    }


}
