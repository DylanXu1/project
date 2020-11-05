package com.chains.project.service.impl;

import com.chains.project.mapper.TeachingMapper;
import com.chains.project.model.vo.TeachingVo;
import com.chains.project.service.TeachingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeachingServiceImpl implements TeachingService {
    @Resource
    private TeachingMapper teachingMapper;

    @Override
    public List getCategoryList(Integer groupId){
        return teachingMapper.getCategoryList(groupId);
    }

    @Override
    public List getclauseList(){
        return teachingMapper.getclauseList();
    }

    @Override
    public List getclauseListBycat(String categoryId){
        return teachingMapper.getclauseListBycat(categoryId);
    }

    @Override
    public TeachingVo teachDetail(Integer teachId){
        return teachingMapper.teachDetail(teachId);
    }

    @Override
    public List<TeachingVo> teachOtherDetail(Integer teachId){
        return teachingMapper.teachOtherDetail(teachId);
    }


}
