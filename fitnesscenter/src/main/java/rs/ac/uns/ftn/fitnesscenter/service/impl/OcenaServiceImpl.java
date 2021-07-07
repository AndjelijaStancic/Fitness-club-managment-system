package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.fitnesscenter.model.*;
import rs.ac.uns.ftn.fitnesscenter.repository.OcenaRepository;

import rs.ac.uns.ftn.fitnesscenter.repository.TrenerRepository;
import rs.ac.uns.ftn.fitnesscenter.service.OcenaService;

import java.util.Set;

@Service
public class OcenaServiceImpl implements OcenaService {
    private final OcenaRepository ocenaRepository;
    private final TrenerRepository trenerRepository;

    public OcenaServiceImpl(OcenaRepository ocenaRepository, TrenerRepository trenerRepository) {
        this.ocenaRepository = ocenaRepository;
        this.trenerRepository = trenerRepository;
    }

    @Override
    public Ocena create(Ocena ocena) throws Exception {
        if (ocena.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Ocena novaOcena = this.ocenaRepository.save(ocena);
        return novaOcena;
    }

    @Override
    public Ocena update(Ocena ocena)  {
        Ocena novaOcena = this.ocenaRepository.save(ocena);
        return novaOcena;
    }
    @Override
    public double updateOcena(Long id){
        Trener trener = trenerRepository.getOne(id);
        Set<Termin> termini = trener.getTerminiTrenera();
        double vrednost = 0;
        int broj = 0;
        for(Termin termin : termini){
            Set<Ocena> ocene = termin.getOcene();
            for(Ocena ocena : ocene){
                vrednost += ocena.getOcena();
                broj++;
            }
        }
        double ocena = vrednost/broj;
        Trener updateTrener = this.trenerRepository.getOne(id);
        updateTrener.setProsecnaOcena(ocena);
        trenerRepository.save(updateTrener);
        return ocena;


    }
}
