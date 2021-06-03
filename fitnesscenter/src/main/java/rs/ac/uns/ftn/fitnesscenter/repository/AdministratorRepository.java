package rs.ac.uns.ftn.fitnesscenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.fitnesscenter.model.Administrator;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
    List<Administrator> findAllById(Long id);
}
