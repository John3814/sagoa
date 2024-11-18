package com.udea.sagoa.controller;

import com.udea.sagoa.dominio.user.UserService;
import com.udea.sagoa.dominio.user.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserData>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
