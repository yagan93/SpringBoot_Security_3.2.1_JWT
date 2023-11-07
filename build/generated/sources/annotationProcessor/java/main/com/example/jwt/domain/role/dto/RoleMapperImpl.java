package com.example.jwt.domain.role.dto;

import com.example.jwt.domain.authority.Authority;
import com.example.jwt.domain.authority.dto.AuthorityDTO;
import com.example.jwt.domain.role.Role;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T18:11:10+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role fromDTO(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        role.setAuthorities( authorityDTOSetToAuthoritySet( dto.getAuthorities() ) );

        return role;
    }

    @Override
    public List<Role> fromDTOs(List<RoleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dtos.size() );
        for ( RoleDTO roleDTO : dtos ) {
            list.add( fromDTO( roleDTO ) );
        }

        return list;
    }

    @Override
    public Set<Role> fromDTOs(Set<RoleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Role> set = new LinkedHashSet<Role>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : dtos ) {
            set.add( fromDTO( roleDTO ) );
        }

        return set;
    }

    @Override
    public RoleDTO toDTO(Role BO) {
        if ( BO == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( BO.getId() );
        roleDTO.setName( BO.getName() );
        roleDTO.setAuthorities( authoritySetToAuthorityDTOSet( BO.getAuthorities() ) );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> toDTOs(List<Role> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( BOs.size() );
        for ( Role role : BOs ) {
            list.add( toDTO( role ) );
        }

        return list;
    }

    @Override
    public Set<RoleDTO> toDTOs(Set<Role> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<RoleDTO> set = new LinkedHashSet<RoleDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Role role : BOs ) {
            set.add( toDTO( role ) );
        }

        return set;
    }

    protected Authority authorityDTOToAuthority(AuthorityDTO authorityDTO) {
        if ( authorityDTO == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( authorityDTO.getId() );
        authority.setName( authorityDTO.getName() );

        return authority;
    }

    protected Set<Authority> authorityDTOSetToAuthoritySet(Set<AuthorityDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Authority> set1 = new LinkedHashSet<Authority>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDTO authorityDTO : set ) {
            set1.add( authorityDTOToAuthority( authorityDTO ) );
        }

        return set1;
    }

    protected AuthorityDTO authorityToAuthorityDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    protected Set<AuthorityDTO> authoritySetToAuthorityDTOSet(Set<Authority> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorityDTO> set1 = new LinkedHashSet<AuthorityDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : set ) {
            set1.add( authorityToAuthorityDTO( authority ) );
        }

        return set1;
    }
}
