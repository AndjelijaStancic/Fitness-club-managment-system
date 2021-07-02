package rs.ac.uns.ftn.fitnesscenter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitnessCentarDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.service.FitnessCentarService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/dodajfitnes")
public class FitnessController {
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public FitnessController(FitnessCentarService fitnessCentarService) {
        this.fitnessCentarService = fitnessCentarService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/dodaj/{uloga}")
    public ResponseEntity<FitnessCentarDTO> getClan(@RequestBody FitDTO dolazna, @PathVariable String uloga) throws Exception {
        if (uloga.equalsIgnoreCase("admin")) {
            FitnessCentar fitnessCentar = new FitnessCentar(dolazna.getNaziv(), dolazna.getAdresa(), dolazna.getBrojTelefona(),
                    dolazna.getEmail(), true);
            FitnessCentar noviCentar = fitnessCentarService.create(fitnessCentar);

            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(noviCentar.getNaziv(), noviCentar.getAdresa(),
                    noviCentar.getBrojTelefona(), noviCentar.getEmail(),noviCentar.getActive());

            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
        } else {
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="/svicentri/{uloga}")
    public ResponseEntity<List<FitnessCentarDTO>> allcenters(@PathVariable String uloga) {
        if(uloga.equalsIgnoreCase("admin")){
            List<FitnessCentarDTO> centri = this.fitnessCentarService.findAllActive();
            return new ResponseEntity<>(centri, HttpStatus.OK);
        }else{
            List<FitnessCentarDTO> centri = new ArrayList<>();
            return new ResponseEntity<>(centri, HttpStatus.OK);
        }
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/obrisi/{id}")
    public ResponseEntity<Void> deleteA(@PathVariable Long id) throws Exception {
        fitnessCentarService.deactivate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}