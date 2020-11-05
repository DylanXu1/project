package com.chains.project.model.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/4/7
 * @version 1.0
 */

@Data
public class Teacher {
    private int teacherId;
    private Integer orgId;
    private Long phone;
    private int userType;
    private String tname;
    private String password;
    private int sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //创建人为企业负责人
    private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private String updateBy;
    private int isDelete;
}
