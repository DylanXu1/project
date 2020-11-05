package com.chains.project.controller;

import com.chains.project.mapper.GradeMapper;
import com.chains.project.model.dto.GradeTeacher;
import com.chains.project.model.vo.GradeVo;
import com.chains.project.service.GradeService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/9/15
 * @version 1.0
 */

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Resource
    private GradeService gradeService;
    @Resource
    private GradeMapper gradeMapper;

    @RequestMapping("/gradeList")
    public Result gradeList(String userId){
        return Result.success(null,gradeService.gradeList(userId));
    }

    @RequestMapping("/addGrade")
    public Result addGrade(GradeVo gradeVo){
        return Result.success(null,gradeService.addGrade(gradeVo));
    }

    @RequestMapping("/delGrade")
    public Result delGrade(Integer gradeId){
        return Result.success(null,gradeService.delGrade(gradeId));
    }

    @RequestMapping("/addGradeTeacher")
    public Result addGradeTeacher(GradeTeacher gradeTeacher){
        int i = gradeMapper.queryTeacherIsExistForGrade(gradeTeacher);
        if(i==0){
            return Result.success(null,gradeService.addGradeTeacher(gradeTeacher));
        }
        return Result.error("添加失败，请勿重复添加");
    }

    @RequestMapping("/gradeTeacherList")
    public Result gradeTeacherList(Integer gradeId){
        return Result.success(null,gradeService.gradeTeacherList(gradeId));
    }

    @RequestMapping("/teacherGradeList")
    public Result teacherGradeList(String userId){
        return Result.success(null,gradeService.teacherGradeList(userId));
    }

    @RequestMapping("/queryTeacherIsExistForGrade")
    public Result queryTeacherIsExistForGrade(GradeTeacher gradeTeacher){
        //System.out.println(gradeId+"======*******======="+teacherId);
        int i = gradeMapper.queryTeacherIsExistForGrade(gradeTeacher);
        return Result.success(null,i);
    }

    @RequestMapping("/delGradeTeacher")
    public Result delGradeTeacher(GradeTeacher gradeTeacher){
        return Result.success(null,gradeService.delGradeTeacher(gradeTeacher));
    }





}
