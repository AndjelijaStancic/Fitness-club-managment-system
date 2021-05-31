package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.repository.TrenerRepository;
import rs.ac.uns.ftn.fitnesscenter.service.TrenerService;
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


}
