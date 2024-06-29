package com.services.product.product_service.service;

import com.services.product.product_service.model.dto.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    AuthResponse createUser(AuthCreateUserRequest authCreateUserRequest);
    AuthResponse loginUser(AuthLoginRequest authLoginRequest);
    Authentication authenticate(String username, String password);
}