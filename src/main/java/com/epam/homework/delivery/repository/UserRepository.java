package com.epam.homework.delivery.repository;

import com.epam.homework.delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findById(Long id);

    User findByLogin(String name);

    User save(User user);

    void deleteById(Long id);

}
