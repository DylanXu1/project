package com.chains.project.model.pojo;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/8/7
 * @version 1.0
 */

@Data
public class Introduce {
    private int introduceId;
    private int itemId;
    private String introTitle;
    private String content;
    private String img;
    private int isDelete;

}
