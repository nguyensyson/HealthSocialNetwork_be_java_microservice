package com.sonns.infratructures.shared;

import com.sonns.business.repo.ReactionsRepo;
import com.sonns.infratructures.repository.ReactionsRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReactionsRepoImpl implements ReactionsRepo {

    private final ReactionsRespository reactionsRespository;

    @Override
    public Integer countLikesByPost(String postId) {
        Integer likesCount = reactionsRespository.countByPostId(postId);
        return likesCount;
    }
}
