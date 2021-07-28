package com.library.libraryv2.repository;

import com.library.libraryv2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
//    User findByEmail(String email);
}
