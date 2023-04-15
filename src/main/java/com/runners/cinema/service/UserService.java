package com.runners.cinema.service;

import com.runners.cinema.convertor.UserConvertor;
import com.runners.cinema.dto.UserDTO;
import com.runners.cinema.dto.request.RegisterRequest;
import com.runners.cinema.exception.ConflictException;
import com.runners.cinema.exception.ErrorMessage;
import com.runners.cinema.exception.ResourceNotFoundException;
import com.runners.cinema.model.Role;
import com.runners.cinema.model.User;
import com.runners.cinema.model.enums.RoleType;
import com.runners.cinema.repository.UserRepository;
import com.runners.cinema.security.SecurityUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final UserConvertor userConvertor;

    public UserService(UserRepository userRepository, RoleService roleService, @Lazy  PasswordEncoder passwordEncoder, UserConvertor userConvertor) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userConvertor = userConvertor;
    }

    public User getUserByEmail(String email) {
       return userRepository.findByEmail(email).orElseThrow(()->
               new ResourceNotFoundException(String.format(ErrorMessage.USER_NOT_FOUND,email)));

    }

    public void save(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail())){
            throw  new ConflictException(String.format(ErrorMessage.CONFLICT_EXCEPTION_MESSAGE,registerRequest.getEmail()));
        }

        Role role=roleService.findByType(RoleType.ROLE_CUSTOMER);

        Set<Role>  roles=new HashSet<>();
        roles.add(role);

        String encodedPassword=passwordEncoder.encode(registerRequest.getPassword());

        User user=new User();
        user.setName(registerRequest.getName());
        user.setSurname(registerRequest.getSurname());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodedPassword);
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setDateOfBirth(registerRequest.getDateOfBirth());
        user.setRole(roles);


        userRepository.save(user);

    }
    public UserDTO getPrinciple() {
        User user = getCurrentUser();

   return  userConvertor.userToUserDTO(user);

    }

    private User getCurrentUser(){
     String email=   SecurityUtils.getCurrentUser().orElseThrow(()->
             new ResourceNotFoundException(ErrorMessage.CURRENT_USER_NOT_FOUND_MESSAGE));
   return getUserByEmail(email);
    }


}
