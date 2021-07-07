package rs.ac.uns.ftn.fitnesscenter.service.impl;
//biznis logika aplikacije

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.fitnesscenter.model.Sala;
import rs.ac.uns.ftn.fitnesscenter.model.Termin;
import rs.ac.uns.ftn.fitnesscenter.model.dto.KriterijumDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.SalaDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminDTO;
import rs.ac.uns.ftn.fitnesscenter.model.dto.TerminProduzenDTO;
import rs.ac.uns.ftn.fitnesscenter.repository.TerminReposiroty;
import rs.ac.uns.ftn.fitnesscenter.service.TerminService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminReposiroty terminReposiroty;

    @Autowired
    public TerminServiceImpl(TerminReposiroty terminReposiroty){ this.terminReposiroty=terminReposiroty; }

    @Override
    public List<Termin> findAll(){
        List<Termin> termini = this.terminReposiroty.findAll();
        return termini;
    }
    @Override
    public Termin create(Termin termin) throws Exception {
        if (termin.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Termin noviTermin = this.terminReposiroty.save(termin);
        return noviTermin;
    }

    @Override
    public Termin update(Termin termin)  {
        Termin noviTermin = this.terminReposiroty.save(termin);
        return noviTermin;
    }

    @Override
    public void delete(Long id) {
        this.terminReposiroty.deleteById(id);
    }

    @Override
    public Termin findOne(Long id) {
        Termin termin = this.terminReposiroty.getOne(id);
        return termin;
    }


    @Override
    public List<TerminDTO> pretragaKriterijum(KriterijumDTO kriterijumDTO) {
        List<Termin> termini = this.terminReposiroty.findAll();
        List<TerminDTO> kriterijum = new ArrayList<>();
        for (Termin termin : termini) {
           TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getPocetakTermina(),termin.getKrajTermina(),termin.getTrajanjeTermina(),termin.getCenaTermina(),termin.getTrening().getNaziv(), termin.getTrening().getTipTreninga(),termin.getTrening().getOpis());
            kriterijum.add(terminDTO);
        }
        if (kriterijumDTO.isSviTermini()) {
            return kriterijum;
        }

        List<TerminDTO> kriterijumCena = new ArrayList<>();
        List<TerminDTO> kriterijumTrajanje = new ArrayList<>();
        List<TerminDTO> kriterijumDatum = new ArrayList<>();
        List<TerminDTO> kriterijumNaziv = new ArrayList<>();
        List<TerminDTO> kriterijumTip = new ArrayList<>();
        List<TerminDTO> kriterijumOpis = new ArrayList<>();

        for (TerminDTO termin : kriterijum) {
            if (kriterijumDTO.getCena() >= termin.getCenaTermina()) {
                kriterijumCena.add(termin);
            }
        }
        for (TerminDTO trajanje : kriterijumCena) {
            if (kriterijumDTO.getTrajanje() >= trajanje.getTrajanjeTermina()) {
                kriterijumTrajanje.add(trajanje);
            }
        }
        for(TerminDTO datum : kriterijumTrajanje){
            if(datum.getPocetakTermina().after(kriterijumDTO.getDatum())){
                kriterijumDatum.add(datum);
            }
        }
        if(kriterijumDTO.getNaziv().equals("sve")){
            for(TerminDTO termin : kriterijumDatum){
                kriterijumNaziv.add(termin);}
        }else{
              for(TerminDTO termin : kriterijumDatum){
                 if(termin.getNazivTreninga().equalsIgnoreCase(kriterijumDTO.getNaziv())){
                    kriterijumNaziv.add(termin);
                }
            }
        }
        if(kriterijumDTO.getTip().equals("sve")){
            for(TerminDTO termin : kriterijumNaziv){
                kriterijumTip.add(termin);}
        }else{
              for(TerminDTO termin : kriterijumNaziv){
                  if(termin.getTipTreninga().equalsIgnoreCase(kriterijumDTO.getTip())){
                     kriterijumTip.add(termin);
                  }
              }
        }
         if(kriterijumDTO.getOpis().equals("sve")){
              for(TerminDTO termin : kriterijumTip){
                    kriterijumOpis.add(termin);}
              return kriterijumOpis;
         }else{
                for(TerminDTO termin : kriterijumTip){
                    if(termin.getOpisTreninga().equalsIgnoreCase(kriterijumDTO.getOpis())){
                        kriterijumOpis.add(termin);
                     }
                }
         }
         return kriterijumOpis;
    }

    @Override
    public Termin deactivate(Long id) throws Exception{
        Termin termin = this.terminReposiroty.getOne(id);
        if(termin == null){
            throw new Exception("Ne postoji termin sa ovim id-em");
        }
        termin.setActive(false);

        Termin termin1 = this.terminReposiroty.save(termin);
        return termin1;
    }

    @Override
    public List<TerminProduzenDTO> findAllActive() {
        List<Termin> termins = this.terminReposiroty.findAll();
        List<TerminProduzenDTO> sviTermini = new ArrayList<>();
        List<TerminProduzenDTO> aktivne = new ArrayList<>();
        for (Termin termin : termins) {
            TerminProduzenDTO terminProduzenDTO = new TerminProduzenDTO( termin.getId(),termin.getPocetakTermina(),termin.getKrajTermina(),
                    termin.getTrajanjeTermina(), termin.getCenaTermina(),termin.getTrening().getNaziv(),
                    termin.getTrening().getTipTreninga(),termin.getTrening().getOpis(),termin.getSala().getOznakaSale(),
                    termin.getSala().getId(),termin.getTrener().getId(),termin.getTrening().getId(),termin.getActive());
            sviTermini.add(terminProduzenDTO);
        }
        for (TerminProduzenDTO terminProduzenDTO : sviTermini) {
            if (terminProduzenDTO.getActive()) {
                aktivne.add(terminProduzenDTO);
            }
        }
        return aktivne;
    }



}



