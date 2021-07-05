package rs.ac.uns.ftn.fitnesscenter.service;
import rs.ac.uns.ftn.fitnesscenter.model.Trening;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TreningDTO;

import java.util.List;

public interface TreningService {
    Trening findOne(Long id);
    List<TreningDTO> findAll();
}
