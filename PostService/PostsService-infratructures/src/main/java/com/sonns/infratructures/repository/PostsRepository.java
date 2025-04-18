package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, String> {
}
