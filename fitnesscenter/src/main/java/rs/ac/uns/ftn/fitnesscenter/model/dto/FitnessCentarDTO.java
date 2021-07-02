package rs.ac.uns.ftn.fitnesscenter.model.dto;



public class FitnessCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String brojTelefona;
    private String email;
    private Boolean active;

    public FitnessCentarDTO() {
    }

    public FitnessCentarDTO(Long id, String naziv, String adresa, String brojTelefona, String email, Boolean active) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public FitnessCentarDTO(String naziv, String adresa, String brojTelefona, String email, Boolean active) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
