package rs.ac.uns.ftn.fitnesscenter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.Administrator;
import rs.ac.uns.ftn.fitnesscenter.model.ClanFitnessCentra;
import rs.ac.uns.ftn.fitnesscenter.model.Trener;
import rs.ac.uns.ftn.fitnesscenter.repository.AdministratorRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.ClanFitnessCentraRepository;
import rs.ac.uns.ftn.fitnesscenter.repository.TrenerRepository;
import rs.ac.uns.ftn.fitnesscenter.service.AdminService;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdminServiceImpl(AdministratorRepository administratorRepository){ this.administratorRepository=administratorRepository; }


    @Override
    public List<Administrator> findAll(){
        List<Administrator> admini = this.administratorRepository.findAll();
        return admini;
    }
}
