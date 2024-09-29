package com.spring.apps_empresariales.repository;

import com.spring.apps_empresariales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //Querys derivadas
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
