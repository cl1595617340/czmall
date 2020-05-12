package com.bdqn.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author KazuGin
 * @since 2020-01-26
 */
@TableName("t_admin")
public class TAdmin implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "admin_id", type = IdType.AUTO)
    private Long adminId;

    @TableField("admin_Name")
    private String adminName;

    private String adminPwd;

    private Long roleId;


    /*一个管理员对应一个角色*/
    @TableField(exist = false)
    private TRole role;

    @TableField("admin_img")
    private String admin_img;

    public String getAdmin_img() {
        return admin_img;
    }

    public void setAdmin_img(String admin_img) {
        this.admin_img = admin_img;
    }

    public TRole getRole() {
        return role;
    }

    public void setRole(TRole role) {
        this.role = role;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TAdmin{" +
        "adminId=" + adminId +
        ", adminName=" + adminName +
        ", adminPwd=" + adminPwd +
        ", roleId=" + roleId +
        "}";
    }
}
