package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMediaRepository extends JpaRepository<PostMedia, String> {
}
