package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.InstallateurDTO;
import com.fadwa.myloopcall.entity.InstallateurEntity;
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
public interface InstallateurMapper {

    InstallateurDTO toDTO(InstallateurEntity installateur);

    InstallateurEntity toEntity(InstallateurDTO installateurDTO);

    List<InstallateurDTO> toDTOList(List<InstallateurEntity> installateurs);

    List<InstallateurEntity> toEntityList(List<InstallateurDTO> installateurDTOs);

    void updateEntityFromDTO(InstallateurDTO installateurDTO, @MappingTarget InstallateurEntity installateur);
}