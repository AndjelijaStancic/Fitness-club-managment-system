package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminProduzenDTO;

import java.util.List;

public interface TerminService {
    List<Termin> findAll();

    Termin create(Termin termin) throws Exception;

    List<TerminDTO> pretragaKriterijum(KriterijumDTO kriterijumDTO);

    List<TerminProduzenDTO> findAllActive();

    //Termin update(Termin termin) throws Exception;

    void delete(Long id);

    Termin findOne(Long idTermina);

    Termin update(Termin termin);

    Termin deactivate(Long id) throws Exception;
}
