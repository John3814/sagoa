package com.udea.sagoa.controller;


import com.udea.sagoa.dominio.user.interfaces.UserAuthData;
import com.udea.sagoa.dominio.user.model.User;
import com.udea.sagoa.infra.security.JWTData;
import com.udea.sagoa.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<JWTData> autenticarUsuario(@RequestBody UserAuthData userAuthData ){
        Authentication authToken= new UsernamePasswordAuthenticationToken(userAuthData.username(),userAuthData.password());
        var userAuhtenticate = authenticationManager.authenticate(authToken);
        var jwt = tokenService.makeToken((User) userAuhtenticate.getPrincipal());
        return ResponseEntity.ok(new JWTData(jwt));
    }

}