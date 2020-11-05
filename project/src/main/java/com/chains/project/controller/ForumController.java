package com.chains.project.controller;

import com.chains.project.model.dto.ForumDto;
import com.chains.project.service.ForumService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/10/28
 * @version 1.0
 */

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Resource
    private ForumService forumService;

    @RequestMapping("/forumList")
    public Result forumList(Long itemId){
        return Result.success(null,forumService.forumList(itemId));
    }

    @RequestMapping("/addForum")
    public Result addForum(ForumDto forumDto){
        System.out.println("收到的评价对象是："+forumDto);
        return Result.success(null,forumService.addForum(forumDto));
    }
}
