package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class PrijavaTerminDTO {
    public Long idTermina;

    public Long idClana;

    public int retVal;

    public PrijavaTerminDTO(Long idTermina, Long idClana, int retVal) {
        this.idTermina = idTermina;
        this.idClana = idClana;
        this.retVal = retVal;
    }

    public Long getIdTermina() {
        return idTermina;
    }

    public void setIdTermina(Long idTermina) {
        this.idTermina = idTermina;
    }

    public Long getIdClana() {
        return idClana;
    }

    public void setIdClana(Long idClana) {
        this.idClana = idClana;
    }

    public int getRetVal() {
        return retVal;
    }

    public void setRetVal(int retVal) {
        this.retVal = retVal;
    }
}
