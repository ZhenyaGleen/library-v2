package com.library.libraryv2.service;

import com.library.libraryv2.dao.UserDao;
import com.library.libraryv2.model.User;
import com.library.libraryv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDao {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User searchUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public List<User> searchUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(Long id) {

        User user = userRepository.findById(id).get();

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());

        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}