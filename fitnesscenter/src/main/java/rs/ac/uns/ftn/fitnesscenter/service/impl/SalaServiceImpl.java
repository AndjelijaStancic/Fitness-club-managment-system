package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;
import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.FitnessCentarRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.SalaRepository;
import rs.ac.uns.ftn.fitnesscenter.service.SalaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {
    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public List<Sala> findAll(){
        List<Sala> sale = this.salaRepository.findAll();
        return sale;
    }

    @Override
    public List<SalaDTO> findAllActive() {
        List<Sala> sale = this.salaRepository.findAll();
        List<SalaDTO> sveSale = new ArrayList<>();
        List<SalaDTO> aktivne = new ArrayList<>();
        for (Sala sala : sale) {
            SalaDTO salaDTO = new SalaDTO(sala.getId(),sala.getOznakaSale(),sala.getKapacitet(),sala.getActive(), sala.getFitnessCentar().getId());
            sveSale.add(salaDTO);
        }
        for (SalaDTO sala : sveSale) {
            if (sala.getActive()) {
                aktivne.add(sala);
            }
        }
        //int a = aktivne.toArray().length;
        //System.out.println(a);
        return aktivne;

    }
    @Override
    public Sala create(Sala sala) throws Exception {
        if (sala.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Sala novaSala = this.salaRepository.save(sala);
        return novaSala;
    }

    @Override
    public Sala update(Sala sala)  {
        Sala novaSala = this.salaRepository.save(sala);
        return novaSala;
    }

    @Override
    public Sala findOne(Long id) {
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }

    @Override
    public void delete(Long id) {
        this.salaRepository.deleteById(id);
    }

    @Override
    public Sala deactivate(Long id) throws Exception{
        Sala sala = this.salaRepository.getOne(id);
        if(sala == null){
            throw new Exception("Ne postoji sala sa ovim id-em");
        }
        sala.setActive(false);

        Sala sala1 = this.salaRepository.save(sala);
        return sala1;
    }

}