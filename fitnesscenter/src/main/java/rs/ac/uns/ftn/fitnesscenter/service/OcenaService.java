package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.Ocena;


public interface OcenaService {

    double updateOcena(Long id);

    Ocena create(Ocena ocena) throws Exception;

    Ocena update(Ocena ocena);
}
