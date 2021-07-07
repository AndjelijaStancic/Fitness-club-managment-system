package rs.ac.uns.ftn.fitnesscenter.model.dto;

import java.util.Date;

public class TerminClanDTO {
    private Long id;
    private Date pocetakTermina;
    private Date krajTermina;
    private int trajanjeTermina;
    private int cenaTermina;
    private String nazivTreninga;
    private String tipTreninga;
    private String opisTreninga;
    private int oznakaSale;
    private String korisnickoTrener;
    private double ocenaTrenera;
    private int kapacitet;
    private int prijavljeni;
    private String fitnesCentar;


    public TerminClanDTO(Long id, Date pocetakTermina, Date krajTermina, int trajanjeTermina, int cenaTermina, String nazivTreninga, String tipTreninga, String opisTreninga, int oznakaSale, String korisnickoTrener, double ocenaTrenera, int kapacitet, int prijavljeni) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.trajanjeTermina = trajanjeTermina;
        this.cenaTermina = cenaTermina;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
        this.oznakaSale = oznakaSale;
        this.korisnickoTrener = korisnickoTrener;
        this.ocenaTrenera = ocenaTrenera;
        this.kapacitet = kapacitet;
        this.prijavljeni = prijavljeni;
    }

    public TerminClanDTO(Long id, Date pocetakTermina, Date krajTermina, int trajanjeTermina, int cenaTermina, String nazivTreninga, String tipTreninga, String opisTreninga, int oznakaSale, String korisnickoTrener, double ocenaTrenera, int kapacitet, int prijavljeni, String fitnesCentar) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.trajanjeTermina = trajanjeTermina;
        this.cenaTermina = cenaTermina;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
        this.oznakaSale = oznakaSale;
        this.korisnickoTrener = korisnickoTrener;
        this.ocenaTrenera = ocenaTrenera;
        this.kapacitet = kapacitet;
        this.prijavljeni = prijavljeni;
        this.fitnesCentar = fitnesCentar;
    }

    public String getFitnesCentar() {
        return fitnesCentar;
    }

    public void setFitnesCentar(String fitnesCentar) {
        this.fitnesCentar = fitnesCentar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKorisnickoTrener() {
        return korisnickoTrener;
    }

    public void setKorisnickoTrener(String korisnickoTrener) {
        this.korisnickoTrener = korisnickoTrener;
    }

    public double getOcenaTrenera() {
        return ocenaTrenera;
    }

    public void setOcenaTrenera(double ocenaTrenera) {
        this.ocenaTrenera = ocenaTrenera;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getPrijavljeni() {
        return prijavljeni;
    }

    public void setPrijavljeni(int prijavljeni) {
        this.prijavljeni = prijavljeni;
    }
}
