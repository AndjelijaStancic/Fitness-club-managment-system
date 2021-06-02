package rs.ac.uns.ftn.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import java.util.List;

public interface ClanFitnessCentraRepository extends JpaRepository<ClanFitnessCentra, Long>{
    //samo deklarisemo metode

    List<ClanFitnessCentra> findByImeAndPrezime(String ime, String prezime);

    List<ClanFitnessCentra> findByImeIgnoreCase(String ime);

    ClanFitnessCentra findByKorisnickoIme(String korisnickoIme);
}


