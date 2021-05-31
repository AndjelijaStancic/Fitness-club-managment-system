package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trener implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,name="korisnicko_ime")
    private String korisnickoIme;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false)
    private String sifra;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name="datum_rodjenja")
    private Date datumRodjenja;

    @Column(unique = true, nullable = false)
    private String telefon;

    @Column(nullable = false)
    private Boolean aktivan;

    @Column(name="prosecna_ocena")
    private double prosecnaOcena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FitnessCentar fitnessCentar;

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> terminiTrenera = new HashSet<>();

    public Trener() { }

    public Trener(Long id, String korisnickoIme, String ime, String prezime, String sifra, String email, Date datumRodjenja, String telefon, Boolean aktivan, double prosecnaOcena, FitnessCentar fitnessCentar, Set<Termin> terminiTrenera) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.telefon = telefon;
        this.aktivan = aktivan;
        this.prosecnaOcena = 0.0;
        this.fitnessCentar = fitnessCentar;
        this.terminiTrenera = terminiTrenera;
    }

    public Trener(String korisnickoIme, String ime, String prezime, String sifra, String email, Date datumRodjenja, String telefon, Boolean aktivan) {
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.telefon = telefon;
        this.aktivan = aktivan;
        this.prosecnaOcena = 0.0;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() { return prezime; }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTelefona() {
        return telefon;
    }

    public void setTelefona(String telefona) {
        this.telefon = telefona;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setTreneri(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }

    public Set<Termin> getTerminiTrenera() { return terminiTrenera; }

    public void setTerminiTrenera(Set<Termin> terminiTrenera) { this.terminiTrenera = terminiTrenera; }
}
