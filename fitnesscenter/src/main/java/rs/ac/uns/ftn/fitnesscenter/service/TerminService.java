package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;

import java.util.List;

public interface TerminService {
    List<Termin> findAll();

    Termin create(Termin termin) throws Exception;

    List<TerminDTO> pretragaKriterijum(KriterijumDTO kriterijumDTO);

    //Termin update(Termin termin) throws Exception;

    void delete(Long id);
}
