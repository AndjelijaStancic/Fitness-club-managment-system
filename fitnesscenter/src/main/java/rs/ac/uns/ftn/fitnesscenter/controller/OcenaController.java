package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.fitnesscenter.model.*;
import rs.ac.uns.ftn.fitnesscenter.model.dto.*;
import rs.ac.uns.ftn.fitnesscenter.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ocene")
public class OcenaController {
    private final TerminService terminService;
    private final ClanFitnessCentraService clanFitnessCentraService;
    private final TrenerService trenerService;
    private final OcenaService ocenaService;

    public OcenaController(TerminService terminService, ClanFitnessCentraService clanFitnessCentraService, TrenerService trenerService, OcenaService ocenaService) {
        this.terminService = terminService;
        this.clanFitnessCentraService = clanFitnessCentraService;
        this.trenerService = trenerService;
        this.ocenaService = ocenaService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/nova")
    public ResponseEntity<OcenaDTO> getTerminiByCrit(@RequestBody OcenaDTO ocenaDolazna) throws Exception {
        Ocena newOcena = new Ocena();
        Termin termin = this.terminService.findOne(ocenaDolazna.getIdTermina());
        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(ocenaDolazna.getIdClana());
        newOcena.setOcena(ocenaDolazna.getProsecnaOcena());
        newOcena.setTermin(termin);
        newOcena.setClanFitnessCentra(clan);
        Ocena povratna = this.ocenaService.create(newOcena);
        OcenaDTO ocenaDTO = new OcenaDTO(povratna.getClanFitnessCentra().getId(), povratna.getTermin().getId(), povratna.getOcena());


        //Trener trener = this.terminService.findOne(ocenaDolazna.getIdTermina()).getTrener();
        //trener.setProsecnaOcena(this.ocenaService.ocena(this.terminService.findOne(ocenaDolazna.getIdTermina()).getTrener().getId()));
        this.ocenaService.updateOcena(this.terminService.findOne(ocenaDolazna.getIdTermina()).getTrener().getId());

        return new ResponseEntity<>(ocenaDTO, HttpStatus.OK);
    }
}
