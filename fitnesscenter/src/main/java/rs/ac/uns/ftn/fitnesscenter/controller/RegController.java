package rs.ac.uns.ftn.fitnesscenter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.*;
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
    public ResponseEntity<TrenerDTO> getTrener(@RequestBody RegDTO dolazna) throws Exception {
        Trener trener = new Trener(dolazna.getKorisnickoIme(),dolazna.getIme(),dolazna.getPrezime(),dolazna.getSifra(),
                dolazna.getEmail(),dolazna.getDatumRodjenja(),dolazna.getKontaktTelefon(),false,false, 0.0);
        Trener noviTrener = trenerService.create(trener);

        TrenerDTO trenerDTO = new TrenerDTO(noviTrener.getId(),noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getEmail(),noviTrener.getKorisnickoIme(),
                noviTrener.getTelefona(), noviTrener.getDatumRodjenja(),noviTrener.getSifra(), noviTrener.getAktivan());

        return new ResponseEntity<>(trenerDTO, HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="zahtevi/{uloga}")
    public ResponseEntity<List<TrenerDTO>> getRequests(@PathVariable String uloga) {
        if(uloga.equals("admin")){
            List<TrenerDTO> treneri = this.trenerService.findRequests();
            return new ResponseEntity<>(treneri, HttpStatus.OK);
        }else{
            List<TrenerDTO> treneri = new ArrayList<>();
            return new ResponseEntity<>(treneri, HttpStatus.OK);
        }
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/approve/{id}")
    public ResponseEntity<TrenerDTO> approve(@PathVariable Long id) throws Exception{
        Trener trener = trenerService.activate(id);
        TrenerDTO trenerDTO = new TrenerDTO(trener.getId(),trener.getIme(),trener.getPrezime(),trener.getEmail(),
                trener.getKorisnickoIme(),trener.getTelefona(),trener.getDatumRodjenja(),trener.getSifra(),
                trener.getAktivan());

        return new ResponseEntity<>(trenerDTO,HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/reject/{id}")
    public ResponseEntity<TrenerDTO> reject(@PathVariable Long id) throws Exception{
        Trener trener = trenerService.deactivate(id);
        TrenerDTO trenerDTO = new TrenerDTO(trener.getId(),trener.getIme(),trener.getPrezime(),trener.getEmail(),
                trener.getKorisnickoIme(),trener.getTelefona(),trener.getDatumRodjenja(),trener.getSifra(),
                trener.getAktivan());

        return new ResponseEntity<>(trenerDTO,HttpStatus.OK);
    }
}
