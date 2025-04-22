package com.sonns.business.dto;

import lombok.Data;

@Data
public class AddCommentRequest {
    private String userId;
    private String postId;
    private String parentId;
    private String content;
}
