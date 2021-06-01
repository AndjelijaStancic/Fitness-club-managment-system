package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.service.TerminService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {

    private final TerminService terminService;

    @Autowired
    public  TerminController(TerminService terminService){this.terminService=terminService;}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/svi")
    public ResponseEntity<List<TerminDTO>> getTermini() {
        List<Termin> terminList = this.terminService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {

            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getPocetakTermina(),
                    termin.getKrajTermina(),termin.getTermin(),termin.getCena(), termin.getTrening().getNaziv(), termin.getTrening().getTipTreninga(),termin.getTrening().getOpis());
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
}


