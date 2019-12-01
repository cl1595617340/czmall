package com.bdqn.springboot.entity;

/**
 * 分页工具类
 *
 */
public class PageBean {

    /**
     * 当前页码
     */
    private Integer pageNo=1;
    /**
     * 每页显示的数量
     */
    private Integer pageSize=3;
    /**
     * 数据总数量、总记录数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    //加入判断
    public void setTotalCount(Integer totalCount) {
        //判断总数量是否大于0，大于0表示有数据
        if(totalCount>0){
            //赋值
            this.totalCount = totalCount;
            //计算总页数 公式 : 总页数 = 数据总数量 % 每页显示的数量  == 0 ? 数据总数量  / 每页显示的数量  : 数据总数量  / 每页显示的数量 + 1;
            this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize +1;

			/*
			//如果总数量 % 每页显示的数量 没有余数
			if(totalCount%pageSize==0){
				//总页数 =  数据总数量  / 每页显示的数量
				this.totalPage = totalCount / pageSize;
			}else{
				//总页数 =  数据总数量  / 每页显示的数量  + 1;
				this.totalPage = totalCount / pageSize + 1;
			}
			*/
        }

    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }


    /**
     * 获取当前页
     */
    public Integer getFirstPage(){
        //(当前页码 - 1) * 每页显示的数量
        return (pageNo-1) * pageSize;
    }


    /**
     * 下一页
     * @return
     */
    public Integer getNextPage(){
        //如果当前页码等于总页数，此时不能点击下一页
        if(pageNo == totalPage){
            return pageNo;
        }else{
            //下一页，加1
            return pageNo + 1;
        }
    }


    /**
     * 上一页
     * @return
     */
    public Integer getPrevPage(){
        //如果当前页码是第一页，此时上一页不能点击
        if(pageNo == 1){
            return pageNo;
        }else{
            //上一页，减1
            return pageNo - 1;
        }
    }
}
