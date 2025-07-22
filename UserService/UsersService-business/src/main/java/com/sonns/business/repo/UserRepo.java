package com.sonns.business.repo;

import com.sonns.business.dto.CreateUsersRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
    void createUser(CreateUsersRequest user);
}
