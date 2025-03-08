package com.study_nest.service;

import com.study_nest.dto.LoginDto;
import com.study_nest.dto.RegisterUserDto;
import com.study_nest.dto.UserDto;
import com.study_nest.model.Department;
import com.study_nest.model.User;
import com.study_nest.repo.DepartmentRepository;
import com.study_nest.repo.UserRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final DepartmentRepository departmentRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            DepartmentRepository departmentRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.departmentRepository = departmentRepository;
    }

    public UserDto signup(RegisterUserDto input) throws BadRequestException {
        if (userRepository.findByEmail(input.getEmail()).isPresent()) {
            throw new BadRequestException("email already taken");
        }

        Optional<Department> department = departmentRepository.findByNameIgnoreCase(input.getCourseOfStudy());
        if(department.isEmpty()){
            throw new BadRequestException("Course of study not found");
        }

        User user = User.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .institution(input.getInstitution())
                .department(department.get())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        User registeredUser = userRepository.save(user);

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

    public User authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }


}
