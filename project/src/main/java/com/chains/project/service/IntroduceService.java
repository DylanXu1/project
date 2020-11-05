package com.chains.project.service;

import com.chains.project.model.pojo.Introduce;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/8/7
 */
public interface IntroduceService {
    List introduceList(int itemId);
    int addIntroduce(Introduce introduce);
}
