package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.PrijavaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;

import java.util.List;

public interface ClanFitnessCentraService {

    ClanFitnessCentra save(ClanFitnessCentra noviClan);

    ClanFitnessCentra findOne(Long id);

    List<ClanFitnessCentra> findAll();

    ClanFitnessCentra create(ClanFitnessCentra clanFitnessCentra) throws Exception;

    ClanFitnessCentra findOne(String korisnickoIme);
    //Termin update(Termin termin) throws Exception;

    void delete(Long id);
}
