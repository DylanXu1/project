package com.chains.project.controller;

import com.chains.project.service.TeachingService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("teach")
public class TeachingController {
    @Resource
    private TeachingService teachingService;

    @RequestMapping("categoryList")
    public Result getCategoryList(Integer groupId){
        return Result.success(null, teachingService.getCategoryList(groupId));
    }

    @RequestMapping("clauseList")
    public Result getclauseList(String categoryId){
        if(categoryId==null||categoryId==""){
            return Result.success(null, teachingService.getclauseList());
        }else {
            return Result.success(null, teachingService.getclauseListBycat(categoryId));
        }
    }

    @RequestMapping("/teachDetail")
    public Result teachDetail(Integer teachId){
        System.out.println("收到teachid"+teachId);
        return Result.success(null, teachingService.teachDetail(teachId));
    }

    @RequestMapping("/teachOtherDetail")
    public Result teachOtherDetail(Integer teachId){
        return Result.success(null, teachingService.teachOtherDetail(teachId));
    }
}
