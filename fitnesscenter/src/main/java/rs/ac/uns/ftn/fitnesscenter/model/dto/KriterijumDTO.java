package rs.ac.uns.ftn.fitnesscenter.model.dto;

import java.util.Date;

public class KriterijumDTO {
    private boolean sviTermini;
    private int cena;
    private int trajanje;
    private Date datum;
    private String naziv;
    private String tip;
    private String opis;

    public KriterijumDTO() {
    }

    public KriterijumDTO(boolean sviTermini, int cena, int trajanje, Date datum, String naziv, String tip, String opis) {
        this.sviTermini = sviTermini;
        this.cena = cena;
        this.trajanje = trajanje;
        this.datum = datum;
        this.naziv = naziv;
        this.tip = tip;
        this.opis = opis;
    }

    public boolean isSviTermini() {
        return sviTermini;
    }

    public void setSviTermini(boolean sviTermini) {
        this.sviTermini = sviTermini;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}