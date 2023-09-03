package com.example.diploma.service;

import com.example.diploma.model.poem.PoemBannedDto;
import com.example.diploma.model.poem.PoemDto;
import com.example.diploma.model.security.AdminPrincipal;

public interface PoemAdminService {
    PoemBannedDto update(long id, PoemBannedDto dto, AdminPrincipal principal);
}
