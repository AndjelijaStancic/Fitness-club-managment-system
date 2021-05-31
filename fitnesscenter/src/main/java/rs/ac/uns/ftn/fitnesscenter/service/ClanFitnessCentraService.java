package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;

import java.util.List;

public interface ClanFitnessCentraService {

    ClanFitnessCentra findOne(Long id);

    List<ClanFitnessCentra> findAll();

    ClanFitnessCentra create(ClanFitnessCentra clanFitnessCentra) throws Exception;


    //Termin update(Termin termin) throws Exception;

    void delete(Long id);
}
