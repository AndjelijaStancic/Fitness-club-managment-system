package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class Sala1DTO {
    private int oznakaSale;
    private int kapacitet;
    private Long idFC;

    public Sala1DTO(int oznakaSale, int kapacitet, Long idFC) {
        this.oznakaSale = oznakaSale;
        this.kapacitet = kapacitet;
        this.idFC = idFC;
    }

    public int getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(int oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public Long getIdFC() {
        return idFC;
    }

    public void setIdFC(Long idFC) {
        this.idFC = idFC;
    }
}
