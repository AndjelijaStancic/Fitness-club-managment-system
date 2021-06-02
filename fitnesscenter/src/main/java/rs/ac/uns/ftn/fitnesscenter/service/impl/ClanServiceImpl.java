package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijavaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.ClanFitnessCentraRepository;
import rs.ac.uns.ftn.fitnesscenter.service.ClanFitnessCentraService;


import java.util.ArrayList;
import java.util.List;

@Service
public class ClanServiceImpl implements ClanFitnessCentraService {

    private final ClanFitnessCentraRepository clanFitnessCentraRepository;

    @Autowired
    public ClanServiceImpl(ClanFitnessCentraRepository clanFitnessCentraRepository){ this.clanFitnessCentraRepository=clanFitnessCentraRepository; }

    @Override
    public ClanFitnessCentra findOne(String korisnickoIme){
        ClanFitnessCentra clan = this.clanFitnessCentraRepository.findByKorisnickoIme(korisnickoIme);
        return clan;
    }

    @Override
    public List<ClanFitnessCentra> findAll(){
        List<ClanFitnessCentra> clanovi = this.clanFitnessCentraRepository.findAll();
        return clanovi;
    }
    @Override
    public ClanFitnessCentra create(ClanFitnessCentra clanFitnessCentra) throws Exception {
        if (clanFitnessCentra.getId() != null) {
            throw new Exception("ID must be null!");
        }
        ClanFitnessCentra noviClan = this.clanFitnessCentraRepository.save(clanFitnessCentra);
        return noviClan;
    }
    @Override
    public void delete(Long id) {
        this.clanFitnessCentraRepository.deleteById(id);
    }

    @Override
    public ClanFitnessCentra findOne(Long id) {
        ClanFitnessCentra clan = this.clanFitnessCentraRepository.getOne(id);
        return clan;
    }



}
