package com.example.ex.service;

import com.example.ex.model.dto.UserLoginDto;
import com.example.ex.model.dto.UserRegisterDto;
import com.example.ex.model.entities.User;

import java.util.Optional;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    User getLoggedUser();

    void logoutUser();
}
