package de.atruvia.simpleweb.presentation.controller;

import de.atruvia.simpleweb.domain.services.PersonService;
import de.atruvia.simpleweb.domain.services.PersonenServiceException;
import de.atruvia.simpleweb.presentation.dto.PersonDto;
import de.atruvia.simpleweb.presentation.mapper.PersonDtoMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;
    private final PersonDtoMapper mapper;


    @ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden")
    @ApiResponse(responseCode = "400", description = "Falsches Format")
    @ApiResponse(responseCode = "500", description = "interner Serverfehler")

    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PersonDto> findById(@PathVariable  String id) throws PersonenServiceException {
        return ResponseEntity.of(service.sucheNachId(id).map(mapper::convert));
    }

    @GetMapping(path="", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<PersonDto>> findAll(
            @RequestParam(required = false, defaultValue = "") String vorname,
            @RequestParam(required = false, defaultValue = "") String nachname
    ) throws PersonenServiceException{
        System.out.printf("Vorname = '%s' Nachname = '%s'\n", vorname, nachname);
        return ResponseEntity.ok(mapper.convert(service.sucheAlle()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable  String id) throws PersonenServiceException {
        if(service.loeschen(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody PersonDto dto) throws PersonenServiceException{
        if(service.speichern_oder_aendern(mapper.convert(dto)))
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrUpdateNotIdemPotent(@RequestBody PersonDto dto, UriComponentsBuilder builder) throws PersonenServiceException{
        dto.setId(UUID.randomUUID().toString());

        var uri = builder.path("/v1/personen/{id}").buildAndExpand(dto.getId());

        service.speichern_oder_aendern(mapper.convert(dto));

        return ResponseEntity.created(uri.toUri()).build();
    }

    // path="/{id}/to-upper"
    @PostMapping(path="/functions/to-upper", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) // ersatz-get
    public ResponseEntity<PersonDto> seltsam(@RequestBody PersonDto dto) {
        dto.setVorname(dto.getVorname().toUpperCase());
        dto.setNachname(dto.getNachname().toUpperCase());
        return ResponseEntity.ok(dto);
    }
}
