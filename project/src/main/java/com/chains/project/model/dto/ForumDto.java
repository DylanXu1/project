package com.chains.project.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xdx
 * @date 2020/10/28
 * @version 1.0
 */

@Data
public class ForumDto {
    private long forumId;
    private long parentId;
    private long itemId;
    private String userId;
    private String forumContemt;
    private int praise;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date forumData;
    private int isDelete;
}
