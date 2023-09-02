package com.example.diploma.service;

import com.example.diploma.model.security.AccessToken;

public interface UserService {

    AccessToken signIn();

    AccessToken signUp();
}
