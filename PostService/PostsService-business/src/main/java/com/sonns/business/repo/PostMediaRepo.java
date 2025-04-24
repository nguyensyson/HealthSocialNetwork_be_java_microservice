package com.sonns.business.repo;

import com.sonns.business.dto.PostMediaDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMediaRepo {
    void savePostMedia(PostMediaDto postMedia);
    void deletePostMedia(String mediaId);
    List<PostMediaDto> getPostMediaByPosts(String id);
}
