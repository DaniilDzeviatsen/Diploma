package com.example.diploma.service;

import com.example.diploma.model.security.AccessToken;
import com.example.diploma.model.security.AccountPrincipal;

public interface AccessTokenService {

    AccessToken generate(AccountPrincipal principal);

    AccountPrincipal authenticate(String accessTokenValue);
}
