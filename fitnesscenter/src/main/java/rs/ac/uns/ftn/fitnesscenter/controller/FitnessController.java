package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.dto.ClanDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitnessCentarDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.RegDTO;
import rs.ac.uns.ftn.fitnesscenter.service.ClanFitnessCentraService;
import rs.ac.uns.ftn.fitnesscenter.service.FitnessCentarService;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;

@RestController
@RequestMapping(value = "")
public class FitnessController {
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public FitnessController(FitnessCentarService fitnessCentarService) {
        this.fitnessCentarService = fitnessCentarService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/api/dodaj")
    public ResponseEntity<FitnessCentarDTO> getClan(@RequestBody FitDTO dolazna) throws Exception {
        FitnessCentar fitnessCentar = new FitnessCentar(dolazna.getNaziv(), dolazna.getAdresa(), dolazna.getBrojTelefona(),
                dolazna.getEmail());
        FitnessCentar noviCentar = fitnessCentarService.create(fitnessCentar);

        FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(noviCentar.getNaziv(), noviCentar.getAdresa(),
                noviCentar.getBrojTelefona(), noviCentar.getEmail());

        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
    }
}
