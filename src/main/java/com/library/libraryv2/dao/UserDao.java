package com.library.libraryv2.dao;

import com.library.libraryv2.model.User;

import java.util.List;

public interface UserDao {

    User searchUser(Long id);

    List<User> searchUsers();

    User createUser(User user);

    User updateUser(Long id);

    void deleteUser(Long id);


}