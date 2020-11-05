package com.chains.project.service.impl;

import com.chains.project.mapper.ImageMapper;
import com.chains.project.model.pojo.Image;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/9/4
 * @version 1.0
 */

@Service
public class ImageServiceImpl {
    @Resource
    private ImageMapper imageMapepr;

    public int addImage(Image image){
        return imageMapepr.addImage(image);
    }
}
