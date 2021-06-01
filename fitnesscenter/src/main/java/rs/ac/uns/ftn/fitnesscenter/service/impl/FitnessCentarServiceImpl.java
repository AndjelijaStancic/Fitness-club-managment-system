package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.repository.ClanFitnessCentraRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.FitnessCentarRepository;
import rs.ac.uns.ftn.fitnesscenter.service.FitnessCentarService;

import java.util.List;

@Service
public class FitnessCentarServiceImpl implements FitnessCentarService {
    private final FitnessCentarRepository fitnessCentarRepository;

    @Autowired
    public FitnessCentarServiceImpl(FitnessCentarRepository fitnessCentarRepository){ this.fitnessCentarRepository=fitnessCentarRepository; }

    @Override
    public List<FitnessCentar> findAll(){
        List<FitnessCentar> centri = this.fitnessCentarRepository.findAll();
        return centri;
    }
    @Override
    public FitnessCentar create(FitnessCentar fitnessCentar) throws Exception {
        if (fitnessCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnessCentar noviCentar = this.fitnessCentarRepository.save(fitnessCentar);
        return noviCentar;
    }
    @Override
    public void delete(Long id) {
        this.fitnessCentarRepository.deleteById(id);
    }

    @Override
    public FitnessCentar findOne(Long id) {
        FitnessCentar centar = this.fitnessCentarRepository.getOne(id);
        return centar;
    }
}
