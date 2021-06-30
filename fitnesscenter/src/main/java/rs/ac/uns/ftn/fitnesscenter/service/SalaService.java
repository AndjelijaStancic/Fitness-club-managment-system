package rs.ac.uns.ftn.fitnesscenter.service;
import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;

import java.util.List;

public interface SalaService {
    List<Sala> findAll();

    List<SalaDTO> findAllActive();

    Sala create(Sala sala) throws Exception;

    void delete(Long id);

    Sala findOne(Long id);

    Sala deactivate(Long id) throws Exception;
}
