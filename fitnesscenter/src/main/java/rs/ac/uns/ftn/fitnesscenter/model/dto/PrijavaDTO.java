package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class PrijavaDTO {
    private String korisnickoIme;
    private String sifra;
    private Long id;
    private int uloga;
    private String poruka;
    private Boolean allert;

    public PrijavaDTO() {
    }

    public PrijavaDTO(String korisnickoIme, String sifra, int uloga, String poruka, Boolean allert) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.uloga = uloga;
        this.poruka = poruka;
        this.allert = allert;
    }

    public PrijavaDTO(String korisnickoIme, String sifra, Long id, int uloga, String poruka, Boolean allert) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.id = id;
        this.uloga = uloga;
        this.poruka = poruka;
        this.allert = allert;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Boolean getAllert() {
        return allert;
    }

    public void setAllert(Boolean allert) {
        this.allert = allert;
    }

    public PrijavaDTO(String korisnickoIme, String sifra, int uloga, String poruka) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.uloga = uloga;
        this.poruka = poruka;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUloga() {
        return uloga;
    }

    public void setUloga(int uloga) {
        this.uloga = uloga;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
