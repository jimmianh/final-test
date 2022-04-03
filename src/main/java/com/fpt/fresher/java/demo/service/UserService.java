package com.fpt.fresher.java.demo.service;

import com.fpt.fresher.java.demo.controller.RegistrationRequest;
import com.fpt.fresher.java.demo.entity.RoleEntity;
import com.fpt.fresher.java.demo.entity.UserEntity;
import com.fpt.fresher.java.demo.repository.RoleEntityRepository;
import com.fpt.fresher.java.demo.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private RoleEntityRepository roleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity saveUser(RegistrationRequest registrationRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(registrationRequest.getPassword());
        userEntity.setLogin(registrationRequest.getLogin());

        RoleEntity userRole = roleEntityRepository.findByName(registrationRequest.getRole());
        if (userRole == null) {
            RoleEntity role = new RoleEntity();
            role.setName(registrationRequest.getRole());
            roleEntityRepository.save(role);
            userRole = roleEntityRepository.findByName(registrationRequest.getRole());
        }

        userEntity.setRoleEntity(userRole);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);
    }

    public UserEntity findByLogin(String login) {
        return userEntityRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
