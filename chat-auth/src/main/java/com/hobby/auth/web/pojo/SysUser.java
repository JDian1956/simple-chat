package com.hobby.auth.web.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Harris
 */
@Data
@ToString
@TableName("sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String userType;
    private String sex;
    private String phone;
    private String email;
    private String avatar;
    private String status;

    @TableLogic
    private String delFlag;
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    private String remark;

}
