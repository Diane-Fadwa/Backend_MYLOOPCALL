package com.fadwa.myloopcall.mapper;

import com.fadwa.myloopcall.dto.ProduitDTO;
import com.fadwa.myloopcall.entity.ProduitEntity;
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
public interface ProduitMapper {

    ProduitDTO toDTO(ProduitEntity produit);

    ProduitEntity toEntity(ProduitDTO produitDTO);

    List<ProduitDTO> toDTOList(List<ProduitEntity> produits);

    List<ProduitEntity> toEntityList(List<ProduitDTO> produitDTOs);

    void updateEntityFromDTO(ProduitDTO produitDTO, @MappingTarget ProduitEntity produit);
}