package com.example.diploma.service;

import com.example.diploma.model.admin.AdminSignInDto;
import com.example.diploma.model.admin.AdminSignUpDto;
import com.example.diploma.model.security.AccessToken;

public interface AdminService {
    AccessToken signIn(AdminSignInDto dto);

    AccessToken signUp(AdminSignUpDto dto);
}
