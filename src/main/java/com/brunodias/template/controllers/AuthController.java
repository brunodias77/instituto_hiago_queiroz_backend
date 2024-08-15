package com.brunodias.template.controllers;

import com.brunodias.template.dtos.requests.auth.LoginAuthRequest;
import com.brunodias.template.dtos.requests.auth.RegisterAuthRequets;
import com.brunodias.template.dtos.responses.auth.LoginAuthResponse;
import com.brunodias.template.entities.User;
import com.brunodias.template.repositories.UserRepository;
import com.brunodias.template.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager _authenticationManager;

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private TokenService _tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginAuthResponse> login(@RequestBody @Valid LoginAuthRequest request){
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        var auth = this._authenticationManager.authenticate(usernamePassword);
        var token = this._tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginAuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterAuthRequets request ){
        var userExist = this._userRepository.findByLogin(request.email());
        if(userExist != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
        var newUser = new User(request.email(), encryptedPassword, request.role());
        this._userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
