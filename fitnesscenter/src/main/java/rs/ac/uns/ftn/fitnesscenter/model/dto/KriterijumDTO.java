package rs.ac.uns.ftn.fitnesscenter.model.dto;

public class KriterijumDTO {
    private boolean sviTermini;
    private int cena;
    private int trajanje;
    private int mesec;
    private String naziv;
    private String tip;
    private String opis;

    public KriterijumDTO() {
    }

    public KriterijumDTO(boolean sviTermini, int cena, int trajanje, int mesec, String naziv, String tip, String opis) {
        this.sviTermini = sviTermini;
        this.cena = cena;
        this.trajanje = trajanje;
        this.mesec = mesec;
        this.naziv = naziv;
        this.tip = tip;
        this.opis = opis;
    }

    public boolean isSviTermini() {
        return sviTermini;
    }

    public void setSviTermini(boolean sviTermini) {
        this.sviTermini = sviTermini;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}