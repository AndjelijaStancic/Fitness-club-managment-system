package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TrenerDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.TrenerRepository;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

        private final TrenerRepository trenerRepository;

        @Autowired
        public TrenerServiceImpl(TrenerRepository trenerRepository){ this.trenerRepository=trenerRepository; }

        @Override
        public Trener findOne(Long id) {
            Trener trener = this.trenerRepository.getOne(id);
            return trener;
        }

        @Override
        public List<Trener> findAll(){
            List<Trener> treneri = this.trenerRepository.findAll();
            return treneri;
        }
        @Override
        public Trener create(Trener trener) throws Exception {
            if (trener.getId() != null) {
                throw new Exception("ID must be null!");
            }
            Trener noviTrener = this.trenerRepository.save(trener);
            return noviTrener;
        }

        @Override
        public void delete(Long id) {
        this.trenerRepository.deleteById(id);
    }

        @Override
        public List<TrenerDTO> findRequests(){
            List<Trener> treners = this.trenerRepository.findAll();
            List<TrenerDTO> trenerDTO = new ArrayList<>();

            for(Trener trener : treners){
                if(!trener.getAktivan()){
                    TrenerDTO trenerDTO1 = new TrenerDTO(trener.getIme(),trener.getPrezime(),trener.getEmail(),trener.getKorisnickoIme(),
                            trener.getTelefona(),trener.getDatumRodjenja(),trener.getSifra(),false);
                    trenerDTO.add(trenerDTO1);
                }
            }
            return trenerDTO;
        }

        @Override
        public Trener activate(Long id) throws Exception{
            Trener trener = this.trenerRepository.getOne(id);
            if(trener == null){
                throw new Exception("Ne postoji trener sa ovim id-em");
            }
            trener.setAktivan(true);

            Trener trener1 = this.trenerRepository.save(trener);
            return trener1;
        }

}
