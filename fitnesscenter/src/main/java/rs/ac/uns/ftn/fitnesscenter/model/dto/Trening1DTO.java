package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class Trening1DTO {
    private String nazivTreninga;
    private String tipTreninga;
    private String opisTreninga;

    public Trening1DTO(String nazivTreninga, String tipTreninga, String opisTreninga) {
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
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
}
