package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="pocetak_termina")
    private Date pocetakTermina;

    @Column(name="kraj_termina")
    private Date krajTermina;

    @Column(name="trajanje_termina")
    private int trajanjeTermina;

    @Column(name="cena_termina")
    private int cenaTermina;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trener trener;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sala sala;

    @ManyToMany(mappedBy = "odradjeniTermini")
    private Set<ClanFitnessCentra> clanovi1 = new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeniTermini")
    private Set<ClanFitnessCentra> clanovi2 = new HashSet<>();

    public Termin() {
    }

    public Termin(Date pocetakTermina, Date krajTermina, int trajanjeTermina, int cenaTermina, Trening trening, Trener trener, Sala sala) {
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.trajanjeTermina = trajanjeTermina;
        this.cenaTermina = cenaTermina;
        this.trening = trening;
        this.trener = trener;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public Date getPocetakTermina() {
        return pocetakTermina;
    }

    public Date getKrajTermina() {
        return krajTermina;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPocetakTermina(Date pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public void setKrajTermina(Date krajTermina) {
        this.krajTermina = krajTermina;
    }


    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) { this.trening = trening; }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Set<Ocena> getOcene() {
        return ocene;
    }

    public void setOcene(Set<Ocena> ocene) {
        this.ocene = ocene;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Set<ClanFitnessCentra> getClanovi1() {
        return clanovi1;
    }

    public void setClanovi1(Set<ClanFitnessCentra> clanovi1) {
        this.clanovi1 = clanovi1;
    }

    public Set<ClanFitnessCentra> getClanovi2() {
        return clanovi2;
    }

    public void setClanovi2(Set<ClanFitnessCentra> clanovi2) {
        this.clanovi2 = clanovi2;
    }

    public int getTrajanjeTermina() {
        return trajanjeTermina;
    }

    public void setTrajanjeTermina(int trajanjeTermina) {
        this.trajanjeTermina = trajanjeTermina;
    }

    public int getCenaTermina() {
        return cenaTermina;
    }

    public void setCenaTermina(int cenaTermina) {
        this.cenaTermina = cenaTermina;
    }
}
