package com.chains.project.controller;

import com.chains.project.model.pojo.Introduce;
import com.chains.project.service.IntroduceService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/8/7
 * @version 1.0
 */

@RestController
@RequestMapping("/introduce")
public class IntroduceController {

    @Resource
    private IntroduceService introduceService;

    @RequestMapping("/introduceList")
    public Result IntroduceList(Integer itemId){
        return Result.success(null,introduceService.introduceList(itemId));
    }

    @RequestMapping("/addIntroduce")
    public Result addIntroduce(Introduce introduce){
        return Result.success(null,introduceService.addIntroduce(introduce));
    }

}
