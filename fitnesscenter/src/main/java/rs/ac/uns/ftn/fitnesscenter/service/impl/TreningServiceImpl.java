package rs.ac.uns.ftn.fitnesscenter.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.Trening;
import rs.ac.uns.ftn.fitnesscenter.model.dto.FitnessCentarDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TreningDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.TrenerRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.TreningRepository;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;
import rs.ac.uns.ftn.fitnesscenter.service.TreningService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreningServiceImpl implements TreningService {
    private final TreningRepository treningRepository;
    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository){ this.treningRepository=treningRepository; }

    @Override
    public Trening findOne(Long id) {
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    @Override
    public List<TreningDTO> findAll(){
        List<Trening> trenings = this.treningRepository.findAll();
        List<TreningDTO> treningDTOS = new ArrayList<>();
        for (Trening tr : trenings) {
            TreningDTO treningDTO = new TreningDTO(tr.getId(),tr.getNaziv(),tr.getTipTreninga(),tr.getOpis());
            treningDTOS.add(treningDTO);
        }
        return treningDTOS;
    }

}
