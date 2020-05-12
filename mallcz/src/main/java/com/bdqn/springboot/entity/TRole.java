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
@TableName("t_role")
public class TRole implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @TableField("role_Name")
    private String roleName;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "TRole{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        "}";
    }
}
