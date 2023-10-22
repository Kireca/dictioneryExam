package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.repository.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
