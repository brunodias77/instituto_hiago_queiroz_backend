package com.brunodias.template.dtos.requests.auth;

import com.brunodias.template.enums.UserRole;

public record RegisterAuthRequets(String firstName, String lastName,  String email, String password, UserRole role) {
}
