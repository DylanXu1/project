package com.chains.project.model.dto;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/9/15
 * @version 1.0
 */

@Data
public class GradeTeacher {
    private int gradeteacherId;
    private int gradeId;
    private String teacherId;
    private long phone;
    private String tname;
    private String gradeName;
    private int isDelete;
}
