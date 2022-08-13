package com.example.jwt.domain.authority;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.role.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "authorities")
    Set<Role> roles = new HashSet<>();

    public Authority() {
    }

    public Authority(UUID id, String name, Set<Role> roles) {
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
}
