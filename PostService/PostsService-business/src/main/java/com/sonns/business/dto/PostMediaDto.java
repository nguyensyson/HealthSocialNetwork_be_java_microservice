package com.sonns.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMediaDto {
    private String id;
    private String postId;
    private String name;
    private String mediaUrl;
}
