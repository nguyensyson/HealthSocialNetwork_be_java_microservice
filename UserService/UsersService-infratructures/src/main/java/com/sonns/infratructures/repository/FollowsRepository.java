package com.sonns.infratructures.repository;

import com.sonns.business.dto.proxy.UserFollowResponseProxy;
import com.sonns.infratructures.model.DeletedStatus;
import com.sonns.infratructures.model.Follows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, String> {
    Optional<Follows> findByFolloweeIdAndFollowerId(String followeeId, String followerId);
    int countByFolloweeIdAndDeleted(String followeeId, DeletedStatus deleted);

    @Query("""
        SELECT 
            u.firstName,
            u.lastName
        FROM Follows f
        INNER JOIN Users u ON u.id = f.followerId
        WHERE f.deleted = 'ACTIVE'
        AND f.followeeId = :userId
    """)
    List<UserFollowResponseProxy> findAlUserFollower(String userId);

    @Query("""
        SELECT 
            u.firstName,
            u.lastName
        FROM Follows f
        INNER JOIN Users u ON u.id = f.followeeId
        WHERE f.deleted = 'ACTIVE'
        AND f.followerId = :userId
    """)
    List<UserFollowResponseProxy> findAlUserFollowing(String userId);
}
