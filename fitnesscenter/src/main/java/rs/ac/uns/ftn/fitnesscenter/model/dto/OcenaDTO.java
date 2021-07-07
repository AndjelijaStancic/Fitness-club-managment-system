package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class OcenaDTO {
    private Long idClana;
    private Long idTermina;
    private Double prosecnaOcena;

    public OcenaDTO(Long idClana, Long idTermina, Double prosecnaOcena) {
        this.idClana = idClana;
        this.idTermina = idTermina;
        this.prosecnaOcena = prosecnaOcena;
    }

    public Long getIdClana() {
        return idClana;
    }

    public void setIdClana(Long idClana) {
        this.idClana = idClana;
    }

    public Long getIdTermina() {
        return idTermina;
    }

    public void setIdTermina(Long idTermina) {
        this.idTermina = idTermina;
    }

    public Double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(Double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }
}
