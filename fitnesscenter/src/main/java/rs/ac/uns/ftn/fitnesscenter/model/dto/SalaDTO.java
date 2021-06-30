package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class SalaDTO {
    private Long id;
    private int oznakaSale;
    private int kapacitet;
    private Boolean active;
    private Long idFC;

    public SalaDTO(Long id, int oznakaSale, int kapacitet, Boolean active, Long idFC) {
        this.id = id;
        this.oznakaSale = oznakaSale;
        this.kapacitet = kapacitet;
        this.active = active;
        this.idFC = idFC;
    }

    public SalaDTO(int oznakaSale, int kapacitet, Boolean active, Long idFC) {
        this.oznakaSale = oznakaSale;
        this.kapacitet = kapacitet;
        this.active = active;
        this.idFC = idFC;
    }

    public SalaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(int oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public Long getIdFC() {
        return idFC;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setIdFC(Long idFC) {
        this.idFC = idFC;
    }
}
