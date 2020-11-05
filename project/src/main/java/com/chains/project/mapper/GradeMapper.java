package com.chains.project.mapper;

import com.chains.project.model.dto.GradeTeacher;
import com.chains.project.model.pojo.Student;
import com.chains.project.model.vo.GradeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/9/15
 */
@Mapper
public interface GradeMapper {
    List<GradeVo> gradeList(String userId);


    int addGrade(GradeVo gradeVo);

    int delGrade(Integer gradeId);

    //给班级添加教师
    //int addGradeTeacher(@Param("gradeId")Long gradeId, @Param("teacherId")Long teacherId);
    int addGradeTeacher(GradeTeacher gradeTeacher);
    //查询该班级教师列表
    List<GradeTeacher> gradeTeacherList(@Param("gradeId")Integer gradeId);
    //查询该教师下的班级列表
    List<GradeTeacher> teacherGradeList(@Param("userId")String userId);
    //查询该班级指定教师是否存在
    int queryTeacherIsExistForGrade(GradeTeacher gradeTeacher);
    //移除班级里的教师
    int delGradeTeacher(GradeTeacher gradeTeacher);

}
