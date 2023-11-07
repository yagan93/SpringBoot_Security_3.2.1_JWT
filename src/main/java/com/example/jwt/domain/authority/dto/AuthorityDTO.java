package com.example.jwt.domain.authority.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AuthorityDTO extends ExtendedDTO {

  @NotNull
  @Size(min = 1, max = 255)
  private String name;

  public AuthorityDTO() {
  }

  public AuthorityDTO(UUID id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public AuthorityDTO setName(String name) {
    this.name = name;
    return this;
  }

}
