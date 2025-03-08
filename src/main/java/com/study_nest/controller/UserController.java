package com.study_nest.controller;

import com.study_nest.dto.UserDto;
import com.study_nest.model.User;
import com.study_nest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public UserDto getUserprofile(){
        User registeredUser = userService.getCurrentUser();
        return UserDto.builder()
                .email(registeredUser.getEmail())
                .firstName(registeredUser.getFirstName())
                .lastName(registeredUser.getLastName())
                .institution(registeredUser.getInstitution())
                .courseOfStudy(registeredUser.getDepartment().getName())
                .createdAt(registeredUser.getCreatedAt())
                .updatedAt(registeredUser.getUpdatedAt())
                .build();
    }
}
