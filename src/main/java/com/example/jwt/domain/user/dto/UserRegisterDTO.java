package com.example.jwt.domain.user.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.core.security.validators.link.Link;
import com.example.jwt.domain.role.dto.RoleDTO;

import javax.validation.constraints.Email;
import java.util.Set;
import java.util.UUID;

public class UserRegisterDTO extends ExtendedDTO {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;


    public UserRegisterDTO() {
    }

    public UserRegisterDTO(UUID id, String firstName, String lastName, String email, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
