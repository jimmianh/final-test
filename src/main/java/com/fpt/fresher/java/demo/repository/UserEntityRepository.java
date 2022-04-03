package com.fpt.fresher.java.demo.repository;



import com.fpt.fresher.java.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}