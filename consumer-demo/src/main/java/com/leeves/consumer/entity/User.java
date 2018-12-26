package com.leeves.consumer.entity;

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

    private Integer id;

    private String userName;

    private String password;

    private String name;

    private String age;

    private String sex;

    private String brithday;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String note;


}
