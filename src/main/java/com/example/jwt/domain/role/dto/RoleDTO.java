package com.example.jwt.domain.role.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.authority.dto.AuthorityDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class RoleDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Valid
    private Set<AuthorityDTO> authorities;

    public RoleDTO() {
    }

    public RoleDTO(UUID id, String name, Set<AuthorityDTO> authorities) {
        super(id);
        this.name = name;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }
}