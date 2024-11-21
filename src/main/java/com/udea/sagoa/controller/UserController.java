package com.udea.sagoa.controller;

import com.udea.sagoa.dominio.user.UserServiceImp;
import com.udea.sagoa.dominio.user.dto.UserData;
import com.udea.sagoa.dominio.user.dto.UserResgistrationData;
import com.udea.sagoa.dominio.user.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserData>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserData> addUser(@RequestBody UserResgistrationData user) {
        return ResponseEntity.ok(this.userService.addUser(user));
    }

}
