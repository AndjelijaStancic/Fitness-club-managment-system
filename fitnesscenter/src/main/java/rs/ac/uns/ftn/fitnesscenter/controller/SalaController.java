package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.*;
import rs.ac.uns.ftn.fitnesscenter.service.FitnessCentarService;
import rs.ac.uns.ftn.fitnesscenter.service.SalaService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/dodajsalu")
public class SalaController {
    private final SalaService salaService;
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public SalaController(SalaService salaService, FitnessCentarService fitnessCentarService ) {
        this.salaService = salaService;
        this.fitnessCentarService = fitnessCentarService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="/svi/{uloga}")
    public ResponseEntity<List<SalaDTO>> getRequests(@PathVariable String uloga) {
        if(uloga.equalsIgnoreCase("admin")){
            List<SalaDTO> sale = this.salaService.findAllActive();
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }else{
            List<SalaDTO> sale = new ArrayList<>();
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value ="/obrisi/{id}")
    public ResponseEntity<Void> deleteA(@PathVariable Long id) throws Exception{
        salaService.deactivate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/dodajS/{uloga}")
    public ResponseEntity<SalaDTO> getSala(@RequestBody Sala1DTO dolazna, @PathVariable String uloga) throws Exception {
        if(uloga.equalsIgnoreCase("admin")) {
            Sala sala = new Sala(dolazna.getKapacitet(), dolazna.getOznakaSale(), true, fitnessCentarService.findOne(dolazna.getIdFC()));
            Sala novaSala = salaService.create(sala);

            SalaDTO salaDTO = new SalaDTO(novaSala.getOznakaSale(),novaSala.getKapacitet(), novaSala.getActive(), novaSala.getFitnessCentar().getId());

            return new ResponseEntity<>(salaDTO, HttpStatus.CREATED);
        }else{
            SalaDTO salaDTO = new SalaDTO();
            return new ResponseEntity<>(salaDTO, HttpStatus.CREATED);
        }
    }

}
