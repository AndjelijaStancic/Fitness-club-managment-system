package rs.ac.uns.ftn.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.fitnesscenter.model.Trening;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long>{

    List<Trening>findByNaziv(String naziv);

    List<Trening>findByTipTreninga(String tipTreninga);

    List<Trening>findByOpis(String opis);

    List<Trening>findByNazivAndAndTipTreninga(String naziv, String tipTreninga);

    List<Trening>findByNazivAndOpis(String naziv,String opis);

    List<Trening>findByTipTreningaAndOpis(String tipTreninga, String opis);

    List<Trening>findByNazivAndTipTreningaAndOpis(String naziv, String tipTreninga, String opis);
}
