package org.example.ex3_service_filiere.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FiliereResponseDto {
    private  Long idFiliere;
    private String code;
    private String libelle;

}
