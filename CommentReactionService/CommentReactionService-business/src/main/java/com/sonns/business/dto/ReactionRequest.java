package com.sonns.business.dto;

import lombok.Data;

@Data
public class ReactionRequest {
    private String userId;
    private String postId;
    private String commentId;
}
