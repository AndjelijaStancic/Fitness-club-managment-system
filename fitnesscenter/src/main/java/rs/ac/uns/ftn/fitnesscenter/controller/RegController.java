package rs.ac.uns.ftn.fitnesscenter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.ClanDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.RegDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.service.ClanFitnessCentraService;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registracija")
public class RegController {
    private final ClanFitnessCentraService clanFitnessCentraService;
    private final TrenerService trenerService;

    @Autowired
    public RegController(ClanFitnessCentraService clanFitnessCentraService, TrenerService trenerService) {
        this.clanFitnessCentraService = clanFitnessCentraService;
        this.trenerService = trenerService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Clan")
    public ResponseEntity<ClanDTO> getClan(@RequestBody RegDTO dolazna) throws Exception {
        ClanFitnessCentra clanFitnessCentra = new ClanFitnessCentra(dolazna.getKorisnickoIme(), dolazna.getIme(), dolazna.getPrezime(),
                dolazna.getSifra(),dolazna.getEmail(),dolazna.getKontaktTelefon(),dolazna.getDatumRodjenja(), true);
        ClanFitnessCentra noviClan = clanFitnessCentraService.create(clanFitnessCentra);

        ClanDTO clanDTO = new ClanDTO(noviClan.getIme(),noviClan.getPrezime(),noviClan.getEmail(),noviClan.getKorisnickoIme(),
                noviClan.getKontaktTelefon(), noviClan.getDatumRodjenja(),noviClan.getSifra(), noviClan.getAktivan());

        return new ResponseEntity<>(clanDTO, HttpStatus.CREATED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Trener")
    public ResponseEntity<ClanDTO> getTrener(@RequestBody RegDTO dolazna) throws Exception {
        Trener trener = new Trener(dolazna.getKorisnickoIme(),dolazna.getIme(),dolazna.getPrezime(),dolazna.getSifra(),
                dolazna.getEmail(),dolazna.getDatumRodjenja(),dolazna.getKontaktTelefon(),false);
        Trener noviTrener = trenerService.create(trener);

        ClanDTO clanDTO = new ClanDTO(noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getEmail(),noviTrener.getKorisnickoIme(),
                noviTrener.getTelefona(), noviTrener.getDatumRodjenja(),noviTrener.getSifra(), noviTrener.getAktivan());

        return new ResponseEntity<>(clanDTO, HttpStatus.CREATED);
    }

}
