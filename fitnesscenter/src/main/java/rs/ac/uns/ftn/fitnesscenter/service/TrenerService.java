package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.Trener;

import java.util.List;

public interface TrenerService {

    Trener findOne(Long id);

    List<Trener> findAll();

    Trener create(Trener trener) throws Exception;

    void delete(Long id);
}