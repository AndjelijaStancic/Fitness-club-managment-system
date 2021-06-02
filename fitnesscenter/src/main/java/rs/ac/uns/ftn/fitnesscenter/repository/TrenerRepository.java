package rs.ac.uns.ftn.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long>{

    List<Trener>findByImeAndPrezime(String ime, String prezime);

    List<Trener>findByImeIgnoreCase(String ime);

    List<Trener> findByFitnessCentar_Naziv(String fitnessCentar);

    List<Trener> findByAktivan(boolean aktivan);

    Trener findByKorisnickoIme(String korisnickoIme);
}
