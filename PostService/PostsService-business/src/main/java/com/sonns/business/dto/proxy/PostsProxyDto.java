package com.sonns.business.dto.proxy;

import java.time.LocalDateTime;

public interface PostsProxyDto {
    String getId();
    String getContent();
    Integer getRepost();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
