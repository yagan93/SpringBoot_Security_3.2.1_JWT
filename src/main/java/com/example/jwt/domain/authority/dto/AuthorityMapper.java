package com.example.jwt.domain.authority.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends ExtendedMapper<Authority, AuthorityDTO> {

}

