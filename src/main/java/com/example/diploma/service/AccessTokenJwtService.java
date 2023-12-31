package com.example.diploma.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.diploma.model.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialExpiredException;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccessTokenJwtService implements AccessTokenService {
    private final Algorithm jwtAlgorithm;

    private final JWTVerifier jwtVerifier;

    private final AccessTokenProperties props;

    @Override
    public AccessToken generate(AccountPrincipal principal) {
        Instant issuedAt = Instant.now();
        Instant expiresAt = issuedAt.plus(props.getTimeToLive());
        String tokenValue = JWT.create()
                .withJWTId(UUID.randomUUID().toString())
                .withSubject(String.valueOf(principal.getId()))
                .withClaim("role", principal.getRole().name())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(jwtAlgorithm);

        return new AccessToken(tokenValue, principal, issuedAt, expiresAt);
    }

    @Override
    public AccountPrincipal authenticate(String accessTokenValue) {
        try {
            DecodedJWT jwt = jwtVerifier.verify(accessTokenValue);
            long accountId = jwt.getClaim("sub").as(Long.class);
            AccountRole accountRole = jwt.getClaim("role").as(AccountRole.class);
            return switch (accountRole) {
                case USER -> new UserPrincipal(accountId);
                case ADMIN -> new AdminPrincipal(accountId);
            };
        } catch (TokenExpiredException e) {
            throw new CredentialsExpiredException("JWT is expired", e);

        } catch (JWTVerificationException e) {
            throw new BadCredentialsException("JWT is invalid", e);
        }

    }
}
