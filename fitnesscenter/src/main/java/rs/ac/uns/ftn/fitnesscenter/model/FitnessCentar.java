package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name ="FITNESS_CENTAR")
public class FitnessCentar implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String naziv;

    @Column(unique = true)
    private String adresa;

    @Column(name="broj_telefona",unique = true)
    private String brojTelefona;

    @Column(unique = true)
    private String email;

    @Column
    private Boolean active;

    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneri = new HashSet<>();

    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();

    public FitnessCentar() {
    }

    public FitnessCentar(Long id, String naziv, String adresa, String brojTelefona, String email, Boolean active) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.active = active;
    }

    public FitnessCentar(String naziv, String adresa, String brojTelefona, String email, Boolean active) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(Set<Trener> treneri) {
        this.treneri = treneri;
    }

    public Set<Sala> getSala() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }


}
