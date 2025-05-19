package com.sonns.infratructures.shared;

import com.sonns.business.dto.FollowRequest;
import com.sonns.business.repo.FollowRepo;
import com.sonns.infratructures.mapper.FollowMapper;
import com.sonns.infratructures.model.DeletedStatus;
import com.sonns.infratructures.model.Follows;
import com.sonns.infratructures.repository.FollowsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FollowRepoImpl implements FollowRepo {

    private final FollowsRepository followsRepository;
    private final FollowMapper followMapper;

    @Override
    public Boolean follow(FollowRequest request) {
        Optional<Follows> optionalFollows = followsRepository.findByFolloweeIdAndFollowerId(request.getFolloweeId(), request.getFollowerId());
        if (optionalFollows.isEmpty()) {
            followsRepository.save(followMapper.toFollows(request));
        } else {
            Follows follows = optionalFollows.get();
            DeletedStatus deletedStatus = follows.getDeleted() == DeletedStatus.ACTIVE ? DeletedStatus.DELETED : DeletedStatus.ACTIVE;
            follows.setDeleted(deletedStatus);
            followsRepository.save(follows);
        }
        return true;
    }

    @Override
    public Integer countFollow(String userId) {
        Integer count = followsRepository.countByFolloweeIdAndDeleted(userId, DeletedStatus.ACTIVE);
        return count;
    }
}
