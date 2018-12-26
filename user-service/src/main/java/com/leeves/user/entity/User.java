package com.leeves.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Leeves
 * @since 2018-12-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("USER_NAME")
    private String userName;

    @TableField("PASSWORD")
    private String password;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private String age;

    @TableField("SEX")
    private String sex;

    @TableField("BRITHDAY")
    private String brithday;

    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @TableField("NOTE")
    private String note;


}
