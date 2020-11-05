package com.chains.project.model.vo;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/9/15
 * @version 1.0
 */

@Data
public class GradeVo {
    private int gradeId;
    private String orgId;
    private String orgName;
    private String gradeName;
    private int isDelete;
}
