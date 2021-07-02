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
@RequestMapping(value = "/api/dodajfitnes")
public class FitnessController {
    private final FitnessCentarService fitnessCentarService;
    private final SalaService salaService;

    @Autowired
    public FitnessController(FitnessCentarService fitnessCentarService, SalaService salaService) {
        this.fitnessCentarService = fitnessCentarService;
        this.salaService = salaService;
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
    public ResponseEntity<Void> deleteF(@PathVariable Long id) throws Exception {
        fitnessCentarService.deactivate(id);
        List<Sala> sala = salaService.findAll();
        for(Sala sala1 : sala){
            if(sala1.getFitnessCentar().getId() == id){
                sala1.setActive(false);
                salaService.update(sala1);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value="/menjaj/{idFC}")
    public ResponseEntity<FitnessCentarDTO> changeF(@RequestBody FitDTO fitDTO, @PathVariable Long idFC){
        FitnessCentar fitPromena = fitnessCentarService.findOne(idFC);
        if(!fitDTO.getNaziv().equals("")){
            fitPromena.setNaziv(fitDTO.getNaziv());
        }
        if(!fitDTO.getAdresa().equals("")){
            fitPromena.setAdresa(fitDTO.getAdresa());
        }
        if(!fitDTO.getBrojTelefona().equals("")){
            fitPromena.setBrojTelefona(fitDTO.getBrojTelefona());
        }
        if(!fitDTO.getEmail().equals("")){
            fitPromena.setEmail(fitDTO.getEmail());
        }

        //System.out.println("PROLAZ 0");
        FitnessCentar izmenjen = fitnessCentarService.update(fitPromena);
        //System.out.println("PROLAZ 1");
        FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitPromena.getNaziv(), fitPromena.getAdresa(),
                fitPromena.getBrojTelefona(), fitPromena.getEmail(),fitPromena.getActive());
        //System.out.println("PROLAZ 2");
        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
    }


}