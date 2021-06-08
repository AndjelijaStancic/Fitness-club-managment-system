package rs.ac.uns.ftn.fitnesscenter.model.dto;

import rs.ac.uns.ftn.fitnesscenter.model.FitnessCentar;

import java.util.Date;

public class TrenerDTO {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String kontaktTelefon;
    private Date datumRodjenja;
    private String sifra;
    private Boolean aktivan;
    private Long idfc;

    public TrenerDTO(Long id, String ime, String prezime, String email, String korisnickoIme, String kontaktTelefon, Date datumRodjenja, String sifra, Boolean aktivan, Long idfc) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.kontaktTelefon = kontaktTelefon;
        this.datumRodjenja = datumRodjenja;
        this.sifra = sifra;
        this.aktivan = aktivan;
        this.idfc = idfc;
    }

    public TrenerDTO() {
    }



    public Long getIdfc() {
        return idfc;
    }

    public void setIdfc(Long idfc) {
        this.idfc = idfc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
