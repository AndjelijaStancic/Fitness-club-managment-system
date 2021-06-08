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
        if(uloga.equalsIgnoreCase("admin")) {
            FitnessCentar fitnessCentar = new FitnessCentar(dolazna.getNaziv(), dolazna.getAdresa(), dolazna.getBrojTelefona(),
                    dolazna.getEmail());
            FitnessCentar noviCentar = fitnessCentarService.create(fitnessCentar);

            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(noviCentar.getNaziv(), noviCentar.getAdresa(),
                    noviCentar.getBrojTelefona(), noviCentar.getEmail());

            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
        }else{
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/svicentri")
    public ResponseEntity<List<FitnessCentarDTO>> getCentri() {
        List<FitnessCentar> centriList = this.fitnessCentarService.findAll();
        List<FitnessCentarDTO> centriDTOS = new ArrayList<>();

        for (FitnessCentar centri : centriList) {

            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(centri.getId(), centri.getNaziv(), centri.getAdresa(),
                    centri.getBrojTelefona(),centri.getEmail());
            centriDTOS.add(fitnessCentarDTO);
        }

        return new ResponseEntity<>(centriDTOS, HttpStatus.OK);
    }
}
