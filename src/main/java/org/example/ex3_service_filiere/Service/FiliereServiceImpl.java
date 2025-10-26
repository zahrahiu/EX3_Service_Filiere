package org.example.ex3_service_filiere.Service;

import org.example.ex3_service_filiere.Dto.FiliereRequestDTO;
import org.example.ex3_service_filiere.Dto.FiliereResponseDto;
import org.example.ex3_service_filiere.Entity.Filiere;
import org.example.ex3_service_filiere.Mappers.FiliereMapper;
import org.example.ex3_service_filiere.Repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FiliereServiceImpl implements FiliererService{

    private FiliereRepository filiereRepository;
    private FiliereMapper filiereMapper;

    public FiliereServiceImpl(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }

    @Override
    public FiliereResponseDto AddFiliere(FiliereRequestDTO filiereRequestDTO) {
        Filiere filiere = filiereMapper.DTO_TO_ENTITY(filiereRequestDTO);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.ENTITY_TO_DTO(savedFiliere);
    }


    @Override
    public void DeleteFiliere(Long id) {
        filiereRepository.deleteById(id);

    }


    @Override
    public List<FiliereResponseDto> GetAllFilieres() {
        List<Filiere> filieres = filiereRepository.findAll();
        List<FiliereResponseDto> filiereResponseDtos = new ArrayList<>();
        for (Filiere filiere : filieres) {
            filiereResponseDtos.add(filiereMapper.ENTITY_TO_DTO(filiere));
        }
        return filiereResponseDtos;
    }

    @Override
    public FiliereResponseDto GetFiliereById(Long id) {
        Filiere filiere = filiereRepository.findById(id).orElseThrow();
        return filiereMapper.ENTITY_TO_DTO(filiere);
    }

    @Override
    public FiliereResponseDto UpdateFiliere(Long id, FiliereRequestDTO filiereRequestDTO) {
        Filiere nv_filiere = filiereMapper.DTO_TO_ENTITY(filiereRequestDTO);
        Filiere filiere = filiereRepository.findById(id).orElseThrow();

        if(nv_filiere.getCode()!=null){
            filiere.setCode(nv_filiere.getCode());
        }
        if(nv_filiere.getLibelle()!=null){
            filiere.setLibelle(nv_filiere.getLibelle());
        }
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.ENTITY_TO_DTO(savedFiliere);
    }
}
