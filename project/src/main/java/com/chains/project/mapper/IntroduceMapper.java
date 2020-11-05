package com.chains.project.mapper;

import com.chains.project.model.pojo.Introduce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/8/7
 */
@Mapper
public interface IntroduceMapper {
    List introduceList(int itemId);
    int addIntroduce(Introduce introduce);


}
