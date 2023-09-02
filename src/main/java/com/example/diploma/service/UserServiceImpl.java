package com.example.diploma.service;

import com.example.diploma.exception.BusinessException;
import com.example.diploma.model.security.AccessToken;
import com.example.diploma.model.security.UserPrincipal;
import com.example.diploma.model.user.User;
import com.example.diploma.model.user.UserSignInDto;
import com.example.diploma.model.user.UserSignUpDto;
import com.example.diploma.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionOperations;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    private final AccessTokenService accessTokenService;

    private final PasswordEncoder passwordEncoder;

    private final TransactionOperations txOps;

    @Override
    public AccessToken signIn(UserSignInDto dto) {
        User user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new BadCredentialsException(""));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPasswordHash())) {
            throw new BadCredentialsException("");
        }
        UserPrincipal principal = UserPrincipal.from(user);
        return accessTokenService.generate(principal);
    }

    @Override
    public AccessToken signUp(UserSignUpDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        User user = create(dto, passwordHash);
        UserPrincipal principal = UserPrincipal.from(user);
        return accessTokenService.generate(principal);
    }

    private User create(UserSignUpDto dto, String passwordHash) {
        return txOps.execute(tx -> {
            boolean existByEmail = userRepo.findByEmail(dto.getEmail()).isPresent();
            if (existByEmail) {
                throw new BusinessException("");
            }
            User user = new User()
                    .setEmail(dto.getEmail())
                    .setUsername(dto.getUsername())
                    .setPasswordHash(passwordHash);
            userRepo.create(user);
            return user;
        });
    }
}

