package com.chains.project.service.impl;
/**
 * @author xdx
 * @date 2020/9/15
 * @version 1.0
 */

import com.chains.project.mapper.GradeMapper;
import com.chains.project.model.dto.GradeTeacher;
import com.chains.project.model.vo.GradeVo;
import com.chains.project.service.GradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Resource
    private GradeMapper gradeMapper;

    @Override
    public List<GradeVo> gradeList(String userId){
        return gradeMapper.gradeList(userId);
    }

    @Override
    public int addGrade(GradeVo gradeVo){
        return gradeMapper.addGrade(gradeVo);
    }

    @Override
    public int delGrade(Integer gradeId){
        return gradeMapper.delGrade(gradeId);
    }

    @Override
    public int addGradeTeacher(GradeTeacher gradeTeacher){
        return gradeMapper.addGradeTeacher(gradeTeacher);
    }

    @Override
    public List<GradeTeacher> gradeTeacherList(Integer gradeId){
        return gradeMapper.gradeTeacherList(gradeId);
    }

    @Override
    public List<GradeTeacher> teacherGradeList(String userId){
        return gradeMapper.teacherGradeList(userId);
    }


    @Override
    public int delGradeTeacher(GradeTeacher gradeTeacher){
        return gradeMapper.delGradeTeacher(gradeTeacher);
    }

}
