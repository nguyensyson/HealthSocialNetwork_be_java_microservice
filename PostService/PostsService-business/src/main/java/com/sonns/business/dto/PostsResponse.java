package com.sonns.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsResponse {
    private String id;
    private String content;
    private Integer likes;
    private Integer comments;
    private Integer repost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
