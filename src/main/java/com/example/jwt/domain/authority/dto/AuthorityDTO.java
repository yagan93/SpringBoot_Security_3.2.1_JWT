package com.example.jwt.domain.authority.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.role.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AuthorityDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    private Set<Role> roles = new HashSet<>();

    public AuthorityDTO() {
    }

    public AuthorityDTO(UUID id, String name, Set<Role> roles) {
        super(id);
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
