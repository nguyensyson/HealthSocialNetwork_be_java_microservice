package com.sonns.infratructures.shared;

import com.sonns.business.dto.CreateUsersRequest;
import com.sonns.business.repo.UserRepo;
import com.sonns.infratructures.mapper.UserMapper;
import com.sonns.infratructures.model.Users;
import com.sonns.infratructures.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepo {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUsersRequest user) {
        Users users = userMapper.toUsers(user);
        usersRepository.save(users);
    }
}
