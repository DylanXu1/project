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
public class Org {
    private int orgId;
    private int userId;
    private String orgName;
    private String functionary;
    private Date CreateTime;
    private int isDelete;


}
