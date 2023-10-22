package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    void loginUser(Long id, String username);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);

}
