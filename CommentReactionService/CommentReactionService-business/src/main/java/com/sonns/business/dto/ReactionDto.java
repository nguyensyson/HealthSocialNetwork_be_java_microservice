package com.sonns.business.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReactionDto {
    private String id;
    private String userId;
    private String postId;
    private String commentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
