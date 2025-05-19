package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.DeletedStatus;
import com.sonns.infratructures.model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, String> {
    Optional<Follows> findByFolloweeIdAndFollowerId(String followeeId, String followerId);
    int countByFolloweeIdAndDeleted(String followeeId, DeletedStatus deleted);
}
