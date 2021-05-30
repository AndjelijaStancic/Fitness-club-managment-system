package rs.ac.uns.ftn.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;

import java.util.List;

public interface TerminReposiroty extends JpaRepository<Termin, Long>{


    List<Termin> findAllById(Long id);

}

