package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.ProspectDTO;
import com.fadwa.myloopcall.entity.ProspectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProspectMapper {

    ProspectDTO toDTO(ProspectEntity prospect);

    ProspectEntity toEntity(ProspectDTO prospectDTO);

    List<ProspectDTO> toDTOList(List<ProspectEntity> prospects);

    List<ProspectEntity> toEntityList(List<ProspectDTO> prospectDTOs);

    void updateEntityFromDTO(ProspectDTO prospectDTO, @MappingTarget ProspectEntity prospect);
}
