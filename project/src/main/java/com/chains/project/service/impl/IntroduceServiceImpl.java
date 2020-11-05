package com.chains.project.service.impl;

import com.chains.project.mapper.IntroduceMapper;
import com.chains.project.model.pojo.Introduce;
import com.chains.project.service.IntroduceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/7
 * @version 1.0
 */

@Service
public class IntroduceServiceImpl implements IntroduceService {

    @Resource
    private IntroduceMapper introduceMapper;

    @Override
    public List introduceList(int itemId){
        return introduceMapper.introduceList(itemId);
    }

    @Override
    public int addIntroduce(Introduce introduce){
        return introduceMapper.addIntroduce(introduce);
    }
}
