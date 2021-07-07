package rs.ac.uns.ftn.fitnesscenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.fitnesscenter.model.*;
import rs.ac.uns.ftn.fitnesscenter.model.dto.*;
import rs.ac.uns.ftn.fitnesscenter.service.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {

    private final TerminService terminService;
    private final SalaService salaService;
    private final TrenerService trenerService;
    private final TreningService treningService;
    private final FitnessCentarService fitnessCentarService;
    private  final ClanFitnessCentraService clanFitnessCentraService;

    public TerminController(TerminService terminService, SalaService salaService, TrenerService trenerService, TreningService treningService,FitnessCentarService fitnessCentarService, ClanFitnessCentraService clanFitnessCentraService) {
        this.terminService = terminService;
        this.salaService = salaService;
        this.trenerService = trenerService;
        this.treningService = treningService;
        this.fitnessCentarService = fitnessCentarService;
        this.clanFitnessCentraService = clanFitnessCentraService;
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
        //System.out.println("A");
        KriterijumDTO kriterijumDTO = new KriterijumDTO(kriterijumDolazna.isSviTermini(), kriterijumDolazna.getCena(), kriterijumDolazna.getTrajanje(), kriterijumDolazna.getDatum(), kriterijumDolazna.getNaziv(),kriterijumDolazna.getTip(),kriterijumDolazna.getOpis());
        //System.out.println("B");
        List<TerminDTO> terminiList = this.terminService.pretragaKriterijum(kriterijumDTO);
        //System.out.println("C");

        List<TerminDTO> terminDTOS = new ArrayList<>();
        //System.out.println("E");
        for (TerminDTO termin : terminiList) {
            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getPocetakTermina(),termin.getKrajTermina(),termin.getTrajanjeTermina(),termin.getCenaTermina(),termin.getNazivTreninga(),termin.getTipTreninga(),termin.getOpisTreninga());
            terminDTOS.add(terminDTO);
            //System.out.println(termin.getId());
            //System.out.println(termin.getKrajTermina());
            //System.out.println(termin.getPocetakTermina());
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/odjava")
    public ResponseEntity<OdjavaTerminDTO> odjavaSaTermina(@RequestBody OdjavaTerminDTO info) throws Exception {
        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(info.getIdClana());
        Set<Termin> prijavljeni = clan.getPrijavljeniTermini();
        Set<Termin> updatedPrijavljeni = new HashSet<>();
        for(Termin termin : prijavljeni){
            if(termin.getId() != info.getIdTermina()){
                updatedPrijavljeni.add(termin);
            }
        }
        clan.setPrijavljeniTermini(updatedPrijavljeni);
        this.clanFitnessCentraService.save(clan);
        OdjavaTerminDTO retVal = new OdjavaTerminDTO(Long.valueOf(1), Long.valueOf(1), 0);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/prijava")
    public ResponseEntity<PrijavaTerminDTO> getTerminiByCrit(@RequestBody PrijavaTerminDTO dolazna) throws Exception {

        Termin newTermin = this.terminService.findOne(dolazna.getIdTermina());
        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(dolazna.getIdClana());

        if(newTermin.getClanovi2().size() >= newTermin.getSala().getKapacitet()){
            PrijavaTerminDTO retVal = new PrijavaTerminDTO(Long.valueOf(0), Long.valueOf(0), -1);
            return new ResponseEntity<>(retVal, HttpStatus.OK);
        }
        Set<Termin> termini = clan.getPrijavljeniTermini();
        termini.add(newTermin);
        clan.setPrijavljeniTermini(termini);
        this.clanFitnessCentraService.save(clan);
        PrijavaTerminDTO retVal = new PrijavaTerminDTO(Long.valueOf(0), Long.valueOf(0), 0);
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/sviTrener/{idT}")
    public ResponseEntity<List<TerminProduzenDTO>> getTerminiTrener(@PathVariable Long idT) {
        List<TerminProduzenDTO> terminList = this.terminService.findAllActive();
        List<TerminProduzenDTO> terminDTOS = new ArrayList<>();

        for (TerminProduzenDTO termin : terminList) {
            if (termin.getIdTrenera() == idT) {
                TerminProduzenDTO terminDTO = new TerminProduzenDTO(termin.getId(), termin.getPocetakTermina(),
                        termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getNazivTreninga(),
                        termin.getTipTreninga(), termin.getOpisTreninga(), termin.getOznakaSale(), termin.getIdSale(),termin.getIdTrenera(),
                        termin.getIdTreninga(),termin.getActive());
                terminDTOS.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/prijavljeni/{idC}")
    public ResponseEntity<List<TerminClanDTO>> getPrijavljeni(@PathVariable Long idC) {

        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(idC);
        Set<Termin> terminList = clan.getPrijavljeniTermini();
        List<TerminClanDTO> terminDTOS = new ArrayList<>();
        for (Termin termin : terminList) {

            TerminClanDTO terminDTO = new TerminClanDTO(termin.getId(), termin.getPocetakTermina(),
                    termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getTrening().getNaziv(),
                    termin.getTrening().getTipTreninga(), termin.getTrening().getOpis(), termin.getSala().getOznakaSale(), termin.getTrener().getKorisnickoIme(),
                    termin.getTrener().getProsecnaOcena(), termin.getSala().getKapacitet(), termin.getClanovi2().size());
                terminDTOS.add(terminDTO);

        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/ocenjeni/{idC}")
    public ResponseEntity<List<TerminClanDTO>> getOcenjeni(@PathVariable Long idC) {

        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(idC);
        Set<Termin> terminList = clan.getOdradjeniTermini();
        List<TerminClanDTO> terminDTOS = new ArrayList<>();
        for (Termin termin : terminList) {
            Set<Ocena> ocene = termin.getOcene();
            boolean x = false;
            double mojaOcena = 0;
            for(Ocena ocena : ocene){
                if(ocena.getClanFitnessCentra().getId() == idC){
                    x = true;
                    mojaOcena = ocena.getOcena();
                    break;
                }
            }
            if(x) {
                TerminClanDTO terminDTO = new TerminClanDTO(termin.getId(), termin.getPocetakTermina(),
                        termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getTrening().getNaziv(),
                        termin.getTrening().getTipTreninga(), termin.getTrening().getOpis(), termin.getSala().getOznakaSale(), termin.getTrener().getKorisnickoIme(),
                        mojaOcena, termin.getSala().getKapacitet(), termin.getClanovi2().size());
                terminDTOS.add(terminDTO);
            }

        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/neocenjeni/{idC}")
    public ResponseEntity<List<TerminClanDTO>> getNeocenjeni(@PathVariable Long idC) {

        ClanFitnessCentra clan = this.clanFitnessCentraService.findOne(idC);
        Set<Termin> terminList = clan.getOdradjeniTermini();
        List<TerminClanDTO> terminDTOS = new ArrayList<>();
        for (Termin termin : terminList) {
            Set<Ocena> ocene = termin.getOcene();
            boolean x = false;
            for(Ocena ocena : ocene){
                if(ocena.getClanFitnessCentra().getId() == idC){
                    x = true;
                    break;
                }
            }
            if(!x) {
                TerminClanDTO terminDTO = new TerminClanDTO(termin.getId(), termin.getPocetakTermina(),
                        termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getTrening().getNaziv(),
                        termin.getTrening().getTipTreninga(), termin.getTrening().getOpis(), termin.getSala().getOznakaSale(), termin.getTrener().getKorisnickoIme(),
                        termin.getTrener().getProsecnaOcena(), termin.getSala().getKapacitet(), termin.getClanovi2().size());
                terminDTOS.add(terminDTO);
            }

        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/info/{idT}")
    public ResponseEntity<TerminClanDTO> getTermin(@PathVariable Long idT) {
        Termin termin = this.terminService.findOne(idT);
        TerminClanDTO terminDTO = new TerminClanDTO(termin.getId(), termin.getPocetakTermina(),
                termin.getKrajTermina(), termin.getTrajanjeTermina(), termin.getCenaTermina(), termin.getTrening().getNaziv(),
                termin.getTrening().getTipTreninga(), termin.getTrening().getOpis(), termin.getSala().getOznakaSale(), termin.getTrener().getKorisnickoIme(),
                termin.getTrener().getProsecnaOcena(), termin.getSala().getKapacitet(), termin.getClanovi2().size(), termin.getSala().getFitnessCentar().getNaziv());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);

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
                                0, Long.valueOf(1), Long.valueOf(0), Long.valueOf(1),false);
                        return new ResponseEntity<>(retVal, HttpStatus.OK);
                    }
                }
            }
            Termin newTermin = new Termin();
            newTermin.setActive(true);
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
                    newTermin.getSala().getOznakaSale(), newTermin.getSala().getId(), newTermin.getTrener().getId(),
                    newTermin.getTrener().getId(),newTermin.getActive());
            return new ResponseEntity<>(retVal, HttpStatus.OK);
        } else {
            TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                    -2, 0, "Nemate prava na ovu komandu!",  "none", "none",
                    0, Long.valueOf(1), Long.valueOf(1), Long.valueOf(1),false);
            return new ResponseEntity<>(retVal, HttpStatus.OK);

        }

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/promeniTermin/{idTermina}")
    public ResponseEntity<TerminProduzenDTO> getTermin(@RequestBody TerminProduzenDTO dolazna, @PathVariable Long idTermina) throws Exception {
            Termin terminPromena = terminService.findOne(idTermina);
            List<Termin> termini = this.terminService.findAll();
            Date date = new Date(110, 8, 6);
                if(!dolazna.getPocetakTermina().before(date)) {
                    List<Termin> sviTermini = terminService.findAll();
                    for(Termin termin : sviTermini) {
                        if(termin.getSala().getId() == terminPromena.getSala().getId()) {
                            if(termin.getId() != terminPromena.getId()) {
                                if((terminPromena.getPocetakTermina().before(termin.getKrajTermina()) && terminPromena.getPocetakTermina().after(termin.getPocetakTermina())) ||
                                        (terminPromena.getKrajTermina().before(termin.getKrajTermina()) && terminPromena.getKrajTermina().after(termin.getPocetakTermina())) ||
                                        (terminPromena.getKrajTermina().after(termin.getKrajTermina()) && terminPromena.getPocetakTermina().before(termin.getPocetakTermina())) ||
                                        terminPromena.getKrajTermina().equals(termin.getKrajTermina()) || terminPromena.getPocetakTermina().equals(termin.getPocetakTermina())) {
                                    TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                                            -1, 0, "Termin se poklapa sa vec postojecim!", "none", "none",
                                            0, Long.valueOf(1), Long.valueOf(0), Long.valueOf(1),false);
                                    return new ResponseEntity<>(retVal, HttpStatus.OK);
                                }
                            }
                        }
                    }
                }

                    /*if ((dolazna.getPocetakTermina().before(terminPromena.getKrajTermina()) && dolazna.getPocetakTermina().after(terminPromena.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().before(terminPromena.getKrajTermina()) && dolazna.getKrajTermina().after(terminPromena.getPocetakTermina())) ||
                            (dolazna.getKrajTermina().after(terminPromena.getKrajTermina()) && dolazna.getPocetakTermina().before(terminPromena.getPocetakTermina())) ||
                            dolazna.getKrajTermina().equals(terminPromena.getKrajTermina()) || dolazna.getPocetakTermina().equals(terminPromena.getPocetakTermina())) {

                        TerminProduzenDTO retVal = new TerminProduzenDTO(Long.valueOf(1), dolazna.getPocetakTermina(), dolazna.getKrajTermina(),
                                -1, 0, "Termin se poklapa sa vec postojecim!", "none", "none",
                                0, Long.valueOf(1), Long.valueOf(0), Long.valueOf(1),false);
                        return new ResponseEntity<>(retVal, HttpStatus.OK);
                    }

                     */

                if(dolazna.getCenaTermina()!=-1){
                    terminPromena.setCenaTermina(dolazna.getCenaTermina());
                }
                //System.out.println(dolazna.getPocetakTermina());
                //System.out.println(date);
                //System.out.println(dolazna.getPocetakTermina().after(date));
                if(dolazna.getPocetakTermina().after(date)){
                    //System.out.println("PROSAO");
                    terminPromena.setPocetakTermina(dolazna.getPocetakTermina());
                    terminPromena.setKrajTermina(dolazna.getKrajTermina());
                    terminPromena.setTrajanjeTermina(dolazna.getTrajanjeTermina());
                }
                if(dolazna.getIdSale() != -1){
                    terminPromena.setSala(this.salaService.findOne(dolazna.getIdSale()));
                }
                if(dolazna.getIdTreninga() != -1){
                    terminPromena.setTrening(this.treningService.findOne(dolazna.getIdTreninga()));
                }
                terminPromena.setTrener(this.trenerService.findOne(dolazna.getIdTrenera()));

            Termin terminRv = this.terminService.update(terminPromena);
            TerminProduzenDTO retVal = new TerminProduzenDTO(terminPromena.getId(), terminPromena.getPocetakTermina(),terminPromena.getKrajTermina(),
                    terminPromena.getTrajanjeTermina(),terminPromena.getCenaTermina(), "","","",
                    terminPromena.getSala().getOznakaSale(), terminPromena.getSala().getId(), terminPromena.getTrener().getId(), terminPromena.getTrener().getId(), terminPromena.getActive());
            return new ResponseEntity<>(retVal, HttpStatus.OK);


        }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value ="/obrisiTermin/{id}")
    public ResponseEntity<Void> deleteT(@PathVariable Long id) throws Exception{
        terminService.deactivate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value ="/proveri/{idC}")
    public ResponseEntity<Void> srediTermine(@PathVariable Long idC) throws Exception{

        ClanFitnessCentra updateClan = this.clanFitnessCentraService.findOne(idC);
        Set<Termin> prijavljeni = updateClan.getPrijavljeniTermini();
        Set<Termin> odradjeni = updateClan.getOdradjeniTermini();

        Set<Termin> prijavljeniUpdated = new HashSet<>();
        Set<Termin> odradjeniUpdated = new HashSet<>();
        java.util.Date sad = new java.util.Date();
        for(Termin termin : odradjeni){
            if(termin.getKrajTermina().after(sad)) {
                prijavljeniUpdated.add(termin);
            } else {
                odradjeniUpdated.add(termin);
            }
        }

        for(Termin termin : prijavljeni){
            if(termin.getKrajTermina().before(sad)) {
                odradjeniUpdated.add(termin);
            } else {
                prijavljeniUpdated.add(termin);
            }
        }
        updateClan.setPrijavljeniTermini(prijavljeniUpdated);
        updateClan.setOdradjeniTermini(odradjeniUpdated);
        this.clanFitnessCentraService.save(updateClan);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/pretraga/{idC}")
    public ResponseEntity<List<TerminDTO>> getTerminiByCritClan(@RequestBody KriterijumDTO kriterijumDolazna,@PathVariable Long idC) throws Exception {

        KriterijumDTO kriterijumDTO = new KriterijumDTO(kriterijumDolazna.isSviTermini(), kriterijumDolazna.getCena(), kriterijumDolazna.getTrajanje(), kriterijumDolazna.getDatum(), kriterijumDolazna.getNaziv(),kriterijumDolazna.getTip(),kriterijumDolazna.getOpis());

        List<TerminDTO> terminiList = this.terminService.pretragaKriterijum(kriterijumDTO);

        Set<Termin> prijavljeniTermini = this.clanFitnessCentraService.findOne(idC).getPrijavljeniTermini();

        List<TerminDTO> terminDTOS = new ArrayList<>();



        for(TerminDTO termin : terminiList) {
            Boolean jeste = false;
            for(Termin termin1 : prijavljeniTermini) {
                if(termin.getId() == termin1.getId()) {
                    jeste = true;
                }
            }

            if(!jeste) {
                terminDTOS.add(termin);
            }
        }

        List<TerminDTO> dostupni = new ArrayList<>();
        java.util.Date date=new java.util.Date();
        for(TerminDTO termin:terminDTOS){
            if(termin.getPocetakTermina().after(date)){
                dostupni.add(termin);
            }
        }

        return new ResponseEntity<>(dostupni, HttpStatus.OK);
    }

    }





