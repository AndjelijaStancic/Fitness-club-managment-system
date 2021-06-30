package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;

    @Column(name = "oznaka_sale")
    private int oznakaSale;

    @Column
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FitnessCentar fitnessCentar;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> terminiSale = new HashSet<>();

    public Sala() {
    }

    public Sala(long id, int kapacitet, int oznakaSale, Boolean active) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.active = active;
    }

    public Sala(int kapacitet, int oznakaSale, Boolean active, FitnessCentar fitnessCentar) {
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.active = active;
        this.fitnessCentar = fitnessCentar;
    }

    public Sala(Long id, int kapacitet, int oznakaSale, Boolean active, FitnessCentar fitnessCentar) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.active = active;
        this.fitnessCentar = fitnessCentar;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(int oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    public Set<Termin> getTerminiSale() {
        return terminiSale;
    }

    public void setTerminiSale(Set<Termin> terminiSale) {
        this.terminiSale = terminiSale;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
