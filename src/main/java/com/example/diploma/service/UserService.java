package com.example.diploma.service;

import com.example.diploma.model.security.AccessToken;
import com.example.diploma.model.user.UserSignInDto;
import com.example.diploma.model.user.UserSignUpDto;

public interface UserService {

    AccessToken signIn(UserSignInDto dto);

    AccessToken signUp(UserSignUpDto dto);
}
