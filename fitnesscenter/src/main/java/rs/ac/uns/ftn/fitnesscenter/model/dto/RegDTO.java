package rs.ac.uns.ftn.fitnesscenter.model.dto;

import java.util.Date;

public class RegDTO {

    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String kontaktTelefon;
    private Date datumRodjenja;
    private String sifra;

    public RegDTO() {
    }

    public RegDTO(String ime, String prezime, String email, String korisnickoIme, String kontaktTelefon, Date datumRodjenja, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.kontaktTelefon = kontaktTelefon;
        this.datumRodjenja = datumRodjenja;
        this.sifra = sifra;

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

}
