package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class TreningDTO {
    private Long id;
    private String nazivTreninga;
    private String tipTreninga;
    private String opisTreninga;

    public TreningDTO(Long id,String nazivTreninga, String tipTreninga, String opisTreninga) {
        this.id=id;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.opisTreninga = opisTreninga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
