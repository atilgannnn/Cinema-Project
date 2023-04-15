package com.runners.cinema.controller;

import com.runners.cinema.dto.UserDTO;
import com.runners.cinema.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final  UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

//Anlik kullaniciyi getir

    @GetMapping("/currentuser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
    public ResponseEntity<UserDTO>  getCurrentUser(){
        UserDTO userDTO = userService.getPrinciple();

        return ResponseEntity.ok(userDTO);

    }
}
