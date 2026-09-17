package com.pragma.person.infrastructure.input.rest;

import com.pragma.person.application.dto.request.PersonRequestDto;
import com.pragma.person.application.dto.response.PersonResponseDto;
import com.pragma.person.application.handler.IPersonHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonRestController {

    private final IPersonHandler personHandler;

    @Operation(summary = "Save a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid person data", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> savePerson(@Valid @RequestBody PersonRequestDto personRequestDto) {
        personHandler.savePerson(personRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all people")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All people returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> getAllPeople() {
        return ResponseEntity.ok(personHandler.getAllPeople());
    }

}