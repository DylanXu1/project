package com.chains.project.service;

import com.chains.project.model.dto.GradeTeacher;
import com.chains.project.model.vo.GradeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/9/15
 */
public interface GradeService {
    List<GradeVo> gradeList(String userId);
    int addGrade(GradeVo gradeVo);

    int delGrade(Integer gradeId);

    int addGradeTeacher(GradeTeacher gradeTeacher);
    List<GradeTeacher> gradeTeacherList(Integer gradeId);
    List<GradeTeacher> teacherGradeList(String userId);

    int delGradeTeacher(GradeTeacher gradeTeacher);
}
