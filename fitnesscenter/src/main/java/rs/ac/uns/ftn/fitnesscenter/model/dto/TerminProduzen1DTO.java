package rs.ac.uns.ftn.fitnesscenter.model.dto;

import java.util.Date;

public class TerminProduzen1DTO {
    private Date pocetakTermina;
    private Date krajTermina;
    private int trajanjeTermina;
    private int cenaTermina;
    private String nazivTreninga;
    private String tipTreninga;
    private String opisTreninga;
    private int oznakaSale;

    public TerminProduzen1DTO(Date pocetakTermina, Date krajTermina, int trajanjeTermina, int cenaTermina, String nazivTreninga, String tipTreninga, String opisTreninga, int oznakaSale) {
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.trajanjeTermina = trajanjeTermina;
        this.cenaTermina = cenaTermina;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
        this.oznakaSale = oznakaSale;
    }

    public int getTrajanjeTermina() {
        return trajanjeTermina;
    }

    public void setTrajanjeTermina(int trajanjeTermina) {
        this.trajanjeTermina = trajanjeTermina;
    }

    public Date getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(Date pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public Date getKrajTermina() {
        return krajTermina;
    }

    public void setKrajTermina(Date krajTermina) {
        this.krajTermina = krajTermina;
    }

    public int getCenaTermina() {
        return cenaTermina;
    }

    public void setCenaTermina(int cenaTermina) {
        this.cenaTermina = cenaTermina;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getOpisTreninga() {
        return opisTreninga;
    }

    public void setOpisTreninga(String opisTreninga) {
        this.opisTreninga = opisTreninga;
    }

    public int getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(int oznakaSale) {
        this.oznakaSale = oznakaSale;
    }
}
