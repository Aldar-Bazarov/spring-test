package com.example.test1.dao;

import com.example.test1.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID uuid = UUID.randomUUID();
        return  insertUser(uuid, user);
    }

    List<User> selectAllUser();

    Optional<User> selectUserById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, User user);
}
