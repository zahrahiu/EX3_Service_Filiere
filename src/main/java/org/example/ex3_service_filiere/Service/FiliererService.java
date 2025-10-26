package org.example.ex3_service_filiere.Service;

import org.example.ex3_service_filiere.Dto.FiliereRequestDTO;
import org.example.ex3_service_filiere.Dto.FiliereResponseDto;

import java.util.List;

public interface FiliererService {
    public FiliereResponseDto AddFiliere(FiliereRequestDTO filiereRequestDTO);
    public void DeleteFiliere(Long id);
    public List<FiliereResponseDto> GetAllFilieres();
    public FiliereResponseDto GetFiliereById(Long id);
    public FiliereResponseDto UpdateFiliere(Long id,FiliereRequestDTO filiereRequestDTO);
}
