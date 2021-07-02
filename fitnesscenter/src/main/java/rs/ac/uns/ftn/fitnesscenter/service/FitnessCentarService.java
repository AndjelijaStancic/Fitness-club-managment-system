package rs.ac.uns.ftn.fitnesscenter.service;

import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitnessCentarDTO;

import java.util.List;

public interface FitnessCentarService {
    FitnessCentar findOne(Long id);

    List<FitnessCentar> findAll();

    FitnessCentar create(FitnessCentar fitnessCentar) throws Exception;

    //FitnessCentar update(FitnessCentar fitnessCentar) throws Exception;

    void delete(Long id);

    FitnessCentar deactivate(Long id) throws Exception;

    List<FitnessCentarDTO> findAllActive();
}
