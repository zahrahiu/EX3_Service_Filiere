package org.example.ex3_service_filiere.Mappers;

import org.example.ex3_service_filiere.Dto.FiliereRequestDTO;
import org.example.ex3_service_filiere.Dto.FiliereResponseDto;
import org.example.ex3_service_filiere.Entity.Filiere;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {

    public Filiere DTO_TO_ENTITY(FiliereRequestDTO filiereRequestDTO) {
        Filiere filiere = new Filiere();
        BeanUtils.copyProperties(filiereRequestDTO, filiere);
        return filiere;
    }

    public FiliereResponseDto ENTITY_TO_DTO(Filiere filiere) {
        FiliereResponseDto filiereResponseDto = new FiliereResponseDto();
        BeanUtils.copyProperties(filiere, filiereResponseDto);
        return filiereResponseDto;
    }
}
