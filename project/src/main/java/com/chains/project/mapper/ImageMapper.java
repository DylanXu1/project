package com.chains.project.mapper;

import com.chains.project.model.pojo.Image;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xdx
 * @date 2020/9/4
 * @version 1.0
 */

@Mapper
public interface ImageMapper {
    int addImage(Image image);
}
