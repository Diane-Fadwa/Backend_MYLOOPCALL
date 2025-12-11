package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.RoleDTO;
import com.fadwa.myloopcall.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface RoleMapper {

    RoleDTO toDTO(RoleEntity role);

//    RoleEntity toEntity(RoleDTO roleDTO);
//
//    List<RoleDTO> toDTOList(List<RoleEntity> roles);
//
//    List<RoleEntity> toEntityList(List<RoleDTO> roleDTOs);
//
//    void updateEntityFromDTO(RoleDTO roleDTO, @MappingTarget RoleEntity role);
//
//    RoleDTO.PermissionDTO toPermissionDTO(RoleEntity.Permission permission);
//
//    RoleEntity.Permission toPermissionEntity(RoleDTO.PermissionDTO permissionDTO);
}