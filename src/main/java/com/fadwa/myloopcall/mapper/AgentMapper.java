package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.AgentDTO;
import com.fadwa.myloopcall.entity.AgentEntity;
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
public interface AgentMapper {

    AgentDTO toDTO(AgentEntity agent);

    AgentEntity toEntity(AgentDTO agentDTO);

    List<AgentDTO> toDTOList(List<AgentEntity> agents);

    List<AgentEntity> toEntityList(List<AgentDTO> agentDTOs);

    void updateEntityFromDTO(AgentDTO agentDTO, @MappingTarget AgentEntity agent);
}