package com.sonns.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsDto {
    private String id;
    private String content;
    private List<PostMediaDto> mediaImages;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
