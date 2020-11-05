package com.chains.project.model.vo;
/**
 * @author xdx
 * @date 2020/9/24
 * @version 1.0
 */

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
/*不需要*/
public class OrgVo {
    private String userId;
    private Long phone;
    private String orgName;
    private int userKind;
    private int userType;
    private String functionary;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String createBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private String updateBy;
    private int isDelete;
}
