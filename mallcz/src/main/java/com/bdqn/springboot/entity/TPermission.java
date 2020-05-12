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
@TableName("t_permission")
public class TPermission implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "permission_id", type = IdType.AUTO)
    private Long permissionId;

    @TableField("permission_Name")
    private String permissionName;

    private Long roleId;


    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "TPermission{" +
        "permissionId=" + permissionId +
        ", permissionName=" + permissionName +
        ", roleId=" + roleId +
        "}";
    }
}
