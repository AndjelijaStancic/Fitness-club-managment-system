package rs.ac.uns.ftn.fitnesscenter.model.dto;

import java.util.Date;

public class TerminProduzenDTO {
    private Long id;
    private Date pocetakTermina;
    private Date krajTermina;
    private int trajanjeTermina;
    private int cenaTermina;
    private String nazivTreninga;
    private String tipTreninga;
    private String opisTreninga;
    private int oznakaSale;
    private Long idSale;
    private Long idTrenera;
    private Long idTreninga;
    private Boolean active;

    public TerminProduzenDTO(Long id, Date pocetakTermina, Date krajTermina, int trajanjeTermina, int cenaTermina, String nazivTreninga, String tipTreninga, String opisTreninga, int oznakaSale, Long idSale, Long idTrenera, Long idTreninga,Boolean active) {

        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.krajTermina = krajTermina;
        this.trajanjeTermina = trajanjeTermina;
        this.cenaTermina = cenaTermina;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
        this.oznakaSale = oznakaSale;
        this.idSale = idSale;
        this.idTrenera = idTrenera;
        this.idTreninga = idTreninga;
        this.active = active;
    }

    public Long getIdTrenera() {
        return idTrenera;
    }

    public void setIdTrenera(Long idTrenera) {
        this.idTrenera = idTrenera;
    }

    public Long getIdTreninga() {
        return idTreninga;
    }

    public void setIdTreninga(Long idTreninga) {
        this.idTreninga = idTreninga;
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

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
