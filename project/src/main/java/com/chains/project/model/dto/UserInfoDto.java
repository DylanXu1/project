package com.chains.project.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/10/24
 * @version 1.0
 */

@Data
public class UserInfoDto {
    private String userId;
    private Long phone;
    private String userName;
    private String img;
    private int sex;
    private String email;
    private Long identity;
    private int age;
    private String password;
    private int isDelete;
}
