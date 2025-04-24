package com.sonns.infratructures.repository;

import com.sonns.business.dto.proxy.PostsProxyDto;
import com.sonns.infratructures.model.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostsRepository extends JpaRepository<Posts, String> {

    @Query("""
        SELECT 
            p.id AS id,
            p.content AS content,
            (SELECT COUNT(r) FROM Posts r WHERE r.parentPost.id = p.id) AS repost,
            p.createdAt AS createdAt,
            p.updatedAt AS updatedAt
        FROM Posts p
        WHERE p.deleted = 'ACTIVE'
    """)
    Page<PostsProxyDto> findAllPostsWithRepost(Pageable pageable);

    @Query("""
        SELECT 
            p.id AS id,
            p.content AS content,
            (SELECT COUNT(r) FROM Posts r WHERE r.parentPost.id = p.id) AS repost,
            p.createdAt AS createdAt,
            p.updatedAt AS updatedAt
        FROM Posts p
        WHERE p.deleted = 'ACTIVE' AND p.id = :postId
    """)
    PostsProxyDto getPostsDetail(String postId);

}
