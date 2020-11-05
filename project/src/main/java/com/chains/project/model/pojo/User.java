package com.chains.project.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */

@Data
public class User {
    private int userSerial;
    private String parentId;
    private String userId;
    private Long phone;
    private String userName;
    private String orgName;
    private String tname;
    private String sname;
    private String password;
    private int gradeId;
    private int userType;
    private int userKind;  /*普通用户/学校用户*/
    private String functionary;
    private String img;
    private int sex;
    private String email;
    private Long identity;
    private int age;
    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;
    private int isDelete;
}
