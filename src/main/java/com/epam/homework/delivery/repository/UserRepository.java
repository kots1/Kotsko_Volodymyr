package com.epam.homework.delivery.repository;

import com.epam.homework.delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {


    User findById(int id);

    User findByLogin(String name);

    User save(User user);

    void deleteById(Long id);

}
