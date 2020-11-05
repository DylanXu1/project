package com.chains.project.model.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/9/24
 * @version 1.0
 */

@Data
public class TeacherVo {
    private int userSerial;
    private String parentId;
    private String userId;
    private Long phone;
    private String userName;
    private String orgName;
    private String tname;
    private int userType;
    private int userKind;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //创建人为企业负责人
    private String createBy;
    private int isDelete;

}
