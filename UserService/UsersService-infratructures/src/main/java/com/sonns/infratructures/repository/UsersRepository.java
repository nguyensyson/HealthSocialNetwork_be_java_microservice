package com.sonns.infratructures.repository;

import com.sonns.infratructures.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByKeycloakId(String keycloakId);
}
