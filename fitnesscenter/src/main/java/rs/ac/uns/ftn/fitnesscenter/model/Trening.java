package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column(name="tip_treninga")
    private String tipTreninga;

    @Column
    private String opis;

    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> termini = new HashSet<>();

    public Trening() {
    }

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public String getOpis() {
        return opis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

    public void setTermini(Set<Termin> termini) {
        this.termini = termini;
    }


}