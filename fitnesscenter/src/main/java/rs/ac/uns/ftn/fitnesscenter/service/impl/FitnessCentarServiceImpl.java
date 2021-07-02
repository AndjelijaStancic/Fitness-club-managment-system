package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitnessCentarDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.ClanFitnessCentraRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.FitnessCentarRepository;
import rs.ac.uns.ftn.fitnesscenter.service.FitnessCentarService;

import java.util.ArrayList;
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
    public List<FitnessCentarDTO> findAllActive() {
        List<FitnessCentar> fitnes = this.fitnessCentarRepository.findAll();
        List<FitnessCentarDTO> sviCentri = new ArrayList<>();
        List<FitnessCentarDTO> aktivne = new ArrayList<>();
        for (FitnessCentar fit : fitnes) {
            FitnessCentarDTO fitDTO = new FitnessCentarDTO(fit.getId(), fit.getNaziv(), fit.getAdresa(), fit.getBrojTelefona(), fit.getEmail(), fit.getActive());
            sviCentri.add(fitDTO);
        }
        for (FitnessCentarDTO fitness : sviCentri) {
            if (fitness.getActive()) {
                aktivne.add(fitness);
            }
        }
        //int a = aktivne.toArray().length;
        //System.out.println(a);
        return aktivne;

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
    public FitnessCentar deactivate(Long id) throws Exception{
        FitnessCentar fit = this.fitnessCentarRepository.getOne(id);
        if(fit == null){
            throw new Exception("Ne postoji fitnes centar sa ovim id-em");
        }
        fit.setActive(false);

        FitnessCentar fit1 = this.fitnessCentarRepository.save(fit);
        return fit1;
    }


    @Override
    public FitnessCentar findOne(Long id) {
        FitnessCentar centar = this.fitnessCentarRepository.getOne(id);
        return centar;
    }
}
