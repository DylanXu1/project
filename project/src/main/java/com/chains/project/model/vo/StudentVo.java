package com.chains.project.model.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/4/8
 * @version 1.0
 */
@Data
public class StudentVo {
    private int userSerial;
    private Long phone;
    private int orgId;
    private String orgName;
    private int gradeId;
    private String gradeName;
    private String sname;
    private int userType;
    private int sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private String updateBy;
    private int isDelete;
}
