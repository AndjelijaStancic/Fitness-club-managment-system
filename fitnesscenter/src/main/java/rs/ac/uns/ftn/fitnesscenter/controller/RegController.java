package rs.ac.uns.ftn.fitnesscenter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.*;
import rs.ac.uns.ftn.fitnesscenter.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registracija")
public class RegController {
    private final ClanFitnessCentraService clanFitnessCentraService;
    private final TrenerService trenerService;
    private final FitnessCentarService fitnessCentarService;
    private final OcenaService ocenaService;
    private final TerminService terminService;

    @Autowired
    public RegController(ClanFitnessCentraService clanFitnessCentraService, TrenerService trenerService, FitnessCentarService fitnessCentarService, OcenaService ocenaService, TerminService terminService) {
        this.clanFitnessCentraService = clanFitnessCentraService;
        this.trenerService = trenerService;
        this.fitnessCentarService = fitnessCentarService;
        this.ocenaService = ocenaService;
        this.terminService = terminService;
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
                dolazna.getEmail(),dolazna.getDatumRodjenja(),dolazna.getKontaktTelefon(),false,false,fitnessCentarService.findOne(dolazna.getIdfc()) );
        Trener noviTrener = trenerService.create(trener);

        TrenerDTO trenerDTO = new TrenerDTO(noviTrener.getId(),noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getEmail(),noviTrener.getKorisnickoIme(),
                noviTrener.getTelefona(), noviTrener.getDatumRodjenja(),noviTrener.getSifra(), noviTrener.getAktivan(),noviTrener.getFitnessCentar().getId());

        return new ResponseEntity<>(trenerDTO, HttpStatus.CREATED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/TrenerAdmin")
    public ResponseEntity<TrenerDTO> getTrenerAdmin(@RequestBody RegDTO dolazna) throws Exception {
        Trener trener = new Trener(dolazna.getKorisnickoIme(),dolazna.getIme(),dolazna.getPrezime(),dolazna.getSifra(),
                dolazna.getEmail(),dolazna.getDatumRodjenja(),dolazna.getKontaktTelefon(),true,false,fitnessCentarService.findOne(dolazna.getIdfc()) );
        Trener noviTrener = trenerService.create(trener);

        TrenerDTO trenerDTO = new TrenerDTO(noviTrener.getId(),noviTrener.getIme(),noviTrener.getPrezime(),noviTrener.getEmail(),noviTrener.getKorisnickoIme(),
                noviTrener.getTelefona(), noviTrener.getDatumRodjenja(),noviTrener.getSifra(), noviTrener.getAktivan(),noviTrener.getFitnessCentar().getId());

        return new ResponseEntity<>(trenerDTO, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="zahtevi/{uloga}")
    public ResponseEntity<List<TrenerDTO>> getRequests(@PathVariable String uloga) {
        System.out.println(uloga);
        if(uloga.equalsIgnoreCase("admin")){
            List<TrenerDTO> treneri = this.trenerService.findRequests();
            return new ResponseEntity<>(treneri, HttpStatus.OK);
        }else{
            List<TrenerDTO> treneri = new ArrayList<>();
            return new ResponseEntity<>(treneri, HttpStatus.OK);
        }
    }
    /*
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="zahtevi")
    public ResponseEntity<List<TrenerDTO>> getRequests() {
            List<TrenerDTO> treneri = this.trenerService.findRequests();
            return new ResponseEntity<>(treneri, HttpStatus.OK);

    }
    */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/approve/{id}")
    public ResponseEntity<TrenerDTO> approve(@PathVariable Long id) throws Exception{
        Trener trener = trenerService.activate(id);
        TrenerDTO trenerDTO = new TrenerDTO(trener.getId(),trener.getIme(),trener.getPrezime(),trener.getEmail(),
                trener.getKorisnickoIme(),trener.getTelefona(),trener.getDatumRodjenja(),trener.getSifra(),
                trener.getAktivan(), trener.getFitnessCentar().getId());

        return new ResponseEntity<>(trenerDTO,HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/reject/{id}")
    public ResponseEntity<TrenerDTO> reject(@PathVariable Long id) throws Exception{
        Trener trener = trenerService.deactivate(id);
        TrenerDTO trenerDTO = new TrenerDTO(trener.getId(),trener.getIme(),trener.getPrezime(),trener.getEmail(),
                trener.getKorisnickoIme(),trener.getTelefona(),trener.getDatumRodjenja(),trener.getSifra(),
                trener.getAktivan(),trener.getFitnessCentar().getId());

        return new ResponseEntity<>(trenerDTO,HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="/podaci/{idT}")
    public ResponseEntity<TrenerDTO> getData(@PathVariable Long idT) {
        Trener trener = trenerService.findOne(idT);
        this.ocenaService.updateOcena(trener.getId());
        //System.out.println(trener.getId());
        TrenerDTO trenerDTO = new TrenerDTO(trener.getIme(), trener.getPrezime(), trener.getEmail(), trener.getKorisnickoIme(),
                trener.getTelefona(),trener.getDatumRodjenja(), trener.getProsecnaOcena());
        //System.out.println(idT);
        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value ="/podaciClan/{idC}")
    public ResponseEntity<ClanDTO> getDataClan(@PathVariable Long idC) {
        ClanFitnessCentra clan = clanFitnessCentraService.findOne(idC);
        ClanDTO clanDTO = new ClanDTO(clan.getIme(),clan.getPrezime(),clan.getEmail(),clan.getKorisnickoIme(),clan.getKontaktTelefon(),
                clan.getDatumRodjenja(),clan.getSifra(),clan.getAktivan());
        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }

}
