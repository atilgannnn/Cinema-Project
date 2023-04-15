package com.runners.cinema.convertor;

import com.runners.cinema.dto.UserDTO;
import com.runners.cinema.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setBuiltIn(user.getBuiltIn());
        userDTO.setPoint(user.getPoint());
        userDTO.setRole(user.getRole());
        return  userDTO;

    }
}
