package com.chains.project.model.dto;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/9/24
 * @version 1.0
 */

@Data
public class OrgDto {
    private String userId;
    private String parentId;
    private Long phone;
    private String orgName;
    private String createBy;
    private String functionary;
    private int isDelete;
}
