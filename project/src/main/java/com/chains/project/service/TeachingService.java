package com.chains.project.service;

import com.chains.project.model.vo.TeachingVo;

import java.util.List;

public interface TeachingService {
    //分类列表
    List getCategoryList(Integer groupId);
    List getclauseList();
    List getclauseListBycat(String categoryId);
    TeachingVo teachDetail(Integer teachId);
    List<TeachingVo> teachOtherDetail(Integer teachId);
}
