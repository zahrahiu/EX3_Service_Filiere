package org.example.ex3_service_filiere.Controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.example.ex3_service_filiere.Dto.FiliereRequestDTO;
import org.example.ex3_service_filiere.Dto.FiliereResponseDto;
import org.example.ex3_service_filiere.Service.FiliereServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Service des filieres",
                description = "Ce service permet de gérer les filières.",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8083"
        )
)

@RestController
@RequestMapping("/v1/Filiere")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class FiliereController {
    private FiliereServiceImpl filiereService;

    public FiliereController(FiliereServiceImpl filiereService) {

        this.filiereService = filiereService;
    }

    @Operation(
            summary = " Ajouter un filiere",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FiliereRequestDTO.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FiliereResponseDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    @PostMapping
    public ResponseEntity<FiliereResponseDto> addFiliere(@RequestBody FiliereRequestDTO filiereRequestDTO) {
        FiliereResponseDto filiereResponseDto = filiereService.AddFiliere(filiereRequestDTO);
        return ResponseEntity.ok(filiereResponseDto);
    }

    @Operation(
            summary = " Afficher liste des filieres",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = FiliereResponseDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping
    public ResponseEntity<List<FiliereResponseDto>> GetAllFilieres() {
        List<FiliereResponseDto> filiereResponseDtos = filiereService.GetAllFilieres();
        return ResponseEntity.ok(filiereResponseDtos);
    }


    @Operation(
            summary = " Afficher filiere par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien Afficher",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FiliereResponseDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<FiliereResponseDto> GetFiliereById(@PathVariable Long id) {
        FiliereResponseDto filiereResponseDto = filiereService.GetFiliereById(id);
        return ResponseEntity.ok(filiereResponseDto);
    }


    @Operation(
            summary = " Modifier un filiere",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FiliereRequestDTO.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = FiliereResponseDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    @PutMapping("/{id}")
    public ResponseEntity<FiliereResponseDto>  updateFiliere(@PathVariable Long id,@RequestBody FiliereRequestDTO filiereRequestDTO) {
        FiliereResponseDto filiereResponseDto = filiereService.UpdateFiliere(id, filiereRequestDTO);
        return ResponseEntity.ok(filiereResponseDto);
    }


    @Operation(
            summary = " supprimer filiere par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    @DeleteMapping("/{id}")
    public ResponseEntity<FiliereResponseDto> deleteFiliere(@PathVariable Long id) {
        filiereService.DeleteFiliere(id);
        return ResponseEntity.ok().build();
    }
}
