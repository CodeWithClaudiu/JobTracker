package com.jobtracker.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jobtracker.backend.dto.PlacementProfileDTO;
import com.jobtracker.backend.model.PlacementProfile;


@Mapper(componentModel = "spring")
public interface PlacementProfileMapper {

    
    PlacementProfileDTO toDTO(PlacementProfile placementProfile);
    List<PlacementProfileDTO> toDTOList(List<PlacementProfile> placementProfiles);


    PlacementProfile toEntity(PlacementProfileDTO placementProfileDTO);
    List<PlacementProfile> toEntityList(List<PlacementProfileDTO> placementProfileDTOs);





}
