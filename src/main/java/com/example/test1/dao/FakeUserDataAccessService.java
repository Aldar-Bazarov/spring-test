package com.example.test1.dao;

import com.example.test1.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {
    private static final List<User> DB = new ArrayList<>();
    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUsername(), user.getPassword()));
        return 0;
    }

    @Override
    public List<User> selectAllUser() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<User> user = selectUserById(id);
        if (user.isEmpty()) {
            return 0;
        }
        DB.remove(user.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, User update) {
        return selectUserById(id)
                .map(user -> {
                    int indexOfUserToUpdate = DB.indexOf(user);
                    if (indexOfUserToUpdate >= 0) {
                        DB.set(indexOfUserToUpdate, new User(id, update.getUsername(), update.getPassword()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
