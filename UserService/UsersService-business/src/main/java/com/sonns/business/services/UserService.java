package com.sonns.business.services;

import com.sonns.business.dto.CreateUsersRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean createUser(CreateUsersRequest user);
}
