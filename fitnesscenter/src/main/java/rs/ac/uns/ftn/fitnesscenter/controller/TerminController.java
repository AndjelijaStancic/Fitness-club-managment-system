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
import rs.ac.uns.ftn.fitnesscenter.service.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {

    private final TerminService terminService;
    private final SalaService salaService;
    private final TrenerService trenerService;
    private final TreningService treningService;
    private final FitnessCentarService fitnessCentarService;

    public TerminController(TerminService terminService, SalaService salaService, TrenerService trenerService, TreningService treningService,FitnessCentarService fitnessCentarService) {
        this.terminService = terminService;
        this.salaService = salaService;
        this.trenerService = trenerService;
        this.treningService = treningService;
        this.fitnessCentarService = fitnessCentarService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/svi")
    public ResponseEntity<List<TerminDTO>> getTermini() {
        List<Termin> terminList = this.terminService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {

            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getPocetakTermina(),
                    termin.getKrajTermina(),termin.getTrajanjeTermina(),termin.getCenaTermina(), termin.getTrening().getNaziv(), termin.getTrening().getTipTreninga(),termin.getTrening().getOpis());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/pretraga")
    public ResponseEntity<List<TerminDTO>> getTerminiByCrit(@RequestBody KriterijumDTO kriterijumDolazna) throws Exception {

        KriterijumDTO kriterijumDTO = new KriterijumDTO(kriterijumDolazna.isSviTermini(), kriterijumDolazna.getCena(), kriterijumDolazna.getTrajanje(), kriterijumDolazna.getMesec(), kriterijumDolazna.getNaziv(),kriterijumDolazna.getTip(),kriterijumDolazna.getOpis());

        List<TerminDTO> terminiList = this.terminService.pretragaKriterijum(kriterijumDTO);


        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (TerminDTO termin : terminiList) {

            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getPocetakTermina(),termin.getKrajTermina(),termin.getTrajanjeTermina(),termin.getCenaTermina(),termin.getNazivTreninga(),termin.getTipTreninga(),termin.getOpisTreninga());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/sviTrener/{idT}")
    public ResponseEntity<List<TerminProduzenDTO>> getTerminiTrener(@PathVariable Long idT) {
        List<Termin> terminList = this.terminService.findAll();
        List<TerminProduzenDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {
            if (termin.getTrener().getId() == idT) {
                TerminProduzenDTO terminDTO = new TerminProduzenDTO(termin.getId(), termin.getPocetakTermina(),
                        termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getTrening().getNaziv(), termin.getTrening().getTipTreninga(), termin.getTrening().getOpis(), termin.getSala().getOznakaSale(), termin.getSala().getId(),termin.getTrener().getId(), termin.getTrening().getId());
                terminDTOS.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/dodaj/{uloga}")
    public ResponseEntity<TerminProduzenDTO> termini(@RequestBody TerminProduzenDTO dolazna, @PathVariable String uloga) throws Exception {
        if (uloga.equalsIgnoreCase("trener")) {
            List<Termin> termini = this.terminService.findAll();
            for(Termin termin : termini){
                if(termin.getSala().getId()==dolazna.getIdSale()){

                    if((dolazna.getPocetakTermina().before(termin.getKrajTermina()) && dolazna.getPocetakTermina().after(termin.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().before(termin.getKrajTermina()) && dolazna.getKrajTermina().after(termin.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().after(termin.getKrajTermina()) && dolazna.getPocetakTermina().before(termin.getPocetakTermina())) ||
                            dolazna.getKrajTermina().equals(termin.getKrajTermina()) || dolazna.getPocetakTermina().equals(termin.getPocetakTermina())) {

                        TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                                -1, 0, "Termin se poklapa sa vec postojecim!",  "none", "none",
                                0, Long.valueOf(1), Long.valueOf(0), Long.valueOf(1));
                        return new ResponseEntity<>(retVal, HttpStatus.OK);
                    }
                }
            }
            Termin newTermin = new Termin();
            newTermin.setPocetakTermina(dolazna.getPocetakTermina());
            newTermin.setKrajTermina(dolazna.getKrajTermina());
            newTermin.setCenaTermina(dolazna.getCenaTermina());
            newTermin.setSala(this.salaService.findOne(dolazna.getIdSale()));
            newTermin.setTrener(this.trenerService.findOne(dolazna.getIdTrenera()));
            newTermin.setTrening(this.treningService.findOne(dolazna.getIdTreninga()));
            newTermin.setTrajanjeTermina(dolazna.getTrajanjeTermina());
            Termin terminRv = this.terminService.create(newTermin);
            TerminProduzenDTO retVal = new TerminProduzenDTO(newTermin.getId(), newTermin.getPocetakTermina(),newTermin.getKrajTermina(),
                    newTermin.getTrajanjeTermina(),newTermin.getCenaTermina(), "","","",
                    newTermin.getSala().getOznakaSale(), newTermin.getSala().getId(), newTermin.getTrener().getId(), newTermin.getTrener().getId());
            return new ResponseEntity<>(retVal, HttpStatus.OK);
        } else {
            TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                    -2, 0, "Nemate prava na ovu komandu!",  "none", "none",
                    0, Long.valueOf(1), Long.valueOf(1), Long.valueOf(1));
            return new ResponseEntity<>(retVal, HttpStatus.OK);

        }

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/promeniTermin/{idTermina}")
    public ResponseEntity<TerminProduzenDTO> getTermin(@RequestBody TerminProduzenDTO dolazna, @PathVariable Long idTermina) throws Exception {
            Termin terminPromena = terminService.findOne(idTermina);
            Date date = new Date(2000, 8, 6);
                if(!dolazna.getPocetakTermina().before(date)){

                    if((dolazna.getPocetakTermina().before(terminPromena.getKrajTermina()) && dolazna.getPocetakTermina().after(terminPromena.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().before(terminPromena.getKrajTermina()) && dolazna.getKrajTermina().after(terminPromena.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().after(terminPromena.getKrajTermina()) && dolazna.getPocetakTermina().before(terminPromena.getPocetakTermina())) ||
                            dolazna.getKrajTermina().equals(terminPromena.getKrajTermina()) || dolazna.getPocetakTermina().equals(terminPromena.getPocetakTermina())) {

                        TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                                -1, 0, "Termin se poklapa sa vec postojecim!",  "none", "none",
                                0, Long.valueOf(1), Long.valueOf(0), Long.valueOf(1));
                        return new ResponseEntity<>(retVal, HttpStatus.OK);
                    }

            }


                if(dolazna.getCenaTermina()!=-1){
                    terminPromena.setCenaTermina(dolazna.getCenaTermina());
                }
                if(dolazna.getPocetakTermina().after(date)){
                    terminPromena.setPocetakTermina(dolazna.getPocetakTermina());
                    terminPromena.setKrajTermina(dolazna.getKrajTermina());
                    terminPromena.setTrajanjeTermina(dolazna.getTrajanjeTermina());
                }
                if(dolazna.getOznakaSale() != -1){
                    terminPromena.setSala(this.salaService.findOne(dolazna.getIdSale()));
                }
                if(dolazna.getIdTreninga() != -1){
                    terminPromena.setTrening(this.treningService.findOne(dolazna.getIdTreninga()));
                }
                terminPromena.setTrener(this.trenerService.findOne(dolazna.getIdTrenera()));

            Termin terminRv = this.terminService.update(terminPromena);
            TerminProduzenDTO retVal = new TerminProduzenDTO(terminPromena.getId(), terminPromena.getPocetakTermina(),terminPromena.getKrajTermina(),
                    terminPromena.getTrajanjeTermina(),terminPromena.getCenaTermina(), "","","",
                    terminPromena.getSala().getOznakaSale(), terminPromena.getSala().getId(), terminPromena.getTrener().getId(), terminPromena.getTrener().getId());
            return new ResponseEntity<>(retVal, HttpStatus.OK);


        }

    }





