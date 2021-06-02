package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.ClanDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijavaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.RegDTO;
import rs.ac.uns.ftn.fitnesscenter.service.ClanFitnessCentraService;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/prijava")
public class prijavaController {
    private final ClanFitnessCentraService clanFitnessCentraService;
    private final TrenerService trenerService;

    @Autowired
    public prijavaController(ClanFitnessCentraService clanFitnessCentraService, TrenerService trenerService) {
        this.clanFitnessCentraService = clanFitnessCentraService;
        this.trenerService = trenerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Clan")
    public ResponseEntity<PrijavaDTO> prijavaClan(@RequestBody PrijDTO dolazna) throws Exception {
        List<ClanFitnessCentra> svi = clanFitnessCentraService.findAll();
        PrijavaDTO prijavaDTO = new PrijavaDTO(dolazna.getKorisnickoIme(), dolazna.getSifra(), 2, "",false);
        for (ClanFitnessCentra clan : svi) {
            //System.out.println(clan.getKorisnickoIme() + " : " + dolazna.getKorisnickoIme());
            //System.out.println(clan.getSifra() + " : " + dolazna.getSifra());
            //System.out.println("u: " + clan.getKorisnickoIme().equalsIgnoreCase(dolazna.getKorisnickoIme()));
            //System.out.println("p: " + clan.getSifra().equals(dolazna.getSifra()));
            if (clan.getKorisnickoIme().equalsIgnoreCase(prijavaDTO.getKorisnickoIme()) && clan.getSifra().equals(prijavaDTO.getSifra())) {
                if (clan.getAktivan() == true) {
                    prijavaDTO.setPoruka("Uspešno ste se ulogovali!");
                    prijavaDTO.setId(clan.getId());
                    prijavaDTO.setAllert(false);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                } else {
                    prijavaDTO.setPoruka("Član nije aktivan! ");
                    prijavaDTO.setAllert(true);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                }
            } else {
                prijavaDTO.setPoruka("Uneli se pogrešnu šifru ili korisničko ime!");
                prijavaDTO.setAllert(true);

            }
        }
        return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/Trener")
    public ResponseEntity<PrijavaDTO> prijavaTrener(@RequestBody PrijDTO dolazna) throws Exception {
        List<Trener> svi = trenerService.findAll();
        PrijavaDTO prijavaDTO = new PrijavaDTO(dolazna.getKorisnickoIme(), dolazna.getSifra(), 3, "");
        for (Trener trener : svi) {
            if (trener.getKorisnickoIme().equalsIgnoreCase(prijavaDTO.getKorisnickoIme()) && trener.getSifra().equalsIgnoreCase(prijavaDTO.getSifra())) {
                if (trener.getAktivan() == true && trener.getObrisan() == false) {
                    prijavaDTO.setPoruka("Uspešno ste se ulogovali!");
                    prijavaDTO.setId(trener.getId());
                    prijavaDTO.setAllert(false);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
                } else {
                    prijavaDTO.setPoruka("Trener nije aktivan ili je obrisan! ");
                    prijavaDTO.setAllert(true);
                    return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);

                }
            } else {
                prijavaDTO.setPoruka("Uneli se pogrešnu šifru ili korisničko ime!");
                prijavaDTO.setAllert(true);
            }
        }
        return new ResponseEntity<>(prijavaDTO, HttpStatus.OK);
    }
}