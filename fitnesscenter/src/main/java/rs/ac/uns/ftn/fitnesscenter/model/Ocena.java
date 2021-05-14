package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ocena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Termin termin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ClanFitnessCentra clanFitnessCentra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public ClanFitnessCentra getClanFitnessCentra() {
        return clanFitnessCentra;
    }

    public void setClanFitnessCentra(ClanFitnessCentra clanFitnessCentra) {
        this.clanFitnessCentra = clanFitnessCentra;
    }
}
