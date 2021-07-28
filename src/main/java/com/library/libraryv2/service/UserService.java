package com.library.libraryv2.service;

import com.library.libraryv2.dao.UserDao;
import com.library.libraryv2.model.User;
import com.library.libraryv2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDao {

    Logger LOGGER = LoggerFactory.getLogger(AuthorService.class);

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
        LOGGER.info("You got users");
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        LOGGER.info("You created user");
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
        LOGGER.info("You updated user");

        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        LOGGER.info("You deleted user");
        userRepository.deleteById(id);
    }
}