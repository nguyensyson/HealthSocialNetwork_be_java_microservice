package com.sonns.business.repo;

import com.sonns.business.dto.PostMediaDto;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMediaRepo {
    void savePostMedia(PostMediaDto postMedia);
}
