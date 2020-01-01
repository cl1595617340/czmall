package com.bdqn.springboot.controller.admin.member;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.springboot.entity.Goods;
import com.bdqn.springboot.entity.Member;
import com.bdqn.springboot.entity.inputSearch.InputSearch;
import com.bdqn.springboot.service.MemberService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/admin/member/member")
public class MemberControllers {

    @Resource
    private MemberService memberService;

    @RequestMapping(value = "/getmemberlist", method = RequestMethod.POST)
    public String productList(String newobj,
                              @RequestParam(value = "page",defaultValue = "1")Long current,
                              @RequestParam(value = "size",defaultValue = "2")Long size
                              ){
        Map<String,Object> map = new HashMap<String, Object>();
        //调用方法
        try {
            /*吧前台传来的json对象解析成goods*/
            Member member = JSON.parseObject(newobj,Member.class);

            //创建分页对象，指定当前页码及每页显示数量
            Page<Member> page = new Page<Member>(current,size);

            //分页查询
            IPage<Member> blogIPage = memberService.getMemberList(page,member);

            //获取数据列表
            List<Member> memberList = blogIPage.getRecords();

            //输入建议
            List<InputSearch> inputSearcheslist = new ArrayList<>();
            for (Member goods1 : memberList) {
                InputSearch inputSearch = new InputSearch();
                inputSearch.setValue(goods1.getMemberName());
                inputSearcheslist.add(inputSearch);
            }

            map.put("data", memberList);
            map.put("page", page);
            //输入建议
            map.put("inputSearcheslist", inputSearcheslist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }

    /*停用和启用会员*/
    @RequestMapping("/updateMemberState")
    public String updateMemberState(Long id,Integer state){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            int res = memberService.updateMemberState(id,state);
            if (res!=0){
                map.put("res", true);
            }else{
                map.put("res", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }
}
