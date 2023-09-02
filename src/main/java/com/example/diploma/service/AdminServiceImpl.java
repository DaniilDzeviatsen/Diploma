package com.example.diploma.service;

import com.example.diploma.exception.BusinessException;
import com.example.diploma.model.admin.Admin;
import com.example.diploma.model.admin.AdminSignInDto;
import com.example.diploma.model.admin.AdminSignUpDto;
import com.example.diploma.model.security.AccessToken;
import com.example.diploma.model.security.AdminPrincipal;
import com.example.diploma.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository adminRepo;

    private final AccessTokenService accessTokenService;

    private final PasswordEncoder passwordEncoder;


    private final TransactionOperations txOps;
    @Override
    public AccessToken signIn(AdminSignInDto dto) {
        Admin admin=adminRepo.findByEmail(dto.getEmail())
                .orElseThrow(()->new BadCredentialsException(""));

        if (!passwordEncoder.matches(dto.getPassword(), admin.getPasswordHash())){
            throw new BadCredentialsException("");
        }
        AdminPrincipal principal=AdminPrincipal.from(admin);
        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken signUp(AdminSignUpDto dto) {
        return null;
    }
}
