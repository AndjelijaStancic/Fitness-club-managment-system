package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TrenerDTO;

import java.util.List;

public interface TrenerService {

    Trener findOne(Long id);

    List<Trener> findAll();

    List<TrenerDTO> findRequests();

    Trener activate(Long id) throws Exception;

    Trener create(Trener trener) throws Exception;

    void delete(Long id);

    public Trener deactivate(Long id) throws Exception;

    Trener findOne(String korisnickoIme);
}