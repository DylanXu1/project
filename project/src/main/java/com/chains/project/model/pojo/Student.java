package com.chains.project.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/4/7
 * @version 1.0
 */
@Data
public class Student {
    private int studentId;
    private Integer orgId;
    private Long phone;
    private int userType;
    private String sname;
    private int gradeId;
    private int sex;
    private String password;
    private Date createTime;
    private int createBy;
    private Date updateTime;
    private int updateBy;
    private int isDelete;

}
