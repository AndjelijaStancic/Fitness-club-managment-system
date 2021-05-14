package rs.ac.uns.ftn.fitnesscenter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="CLAN_FITNESS_CENTRA")
public class ClanFitnessCentra implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable = false, unique = true, name="korisnicko_ime")
        private String korisnickoIme;

        @Column(nullable = false)
        private String ime;

        @Column(nullable = false)
        private String prezime;

        @Column(nullable = false)
        private String sifra;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false, unique = true)
        private String telefon;

        @Column(nullable = false, name="datum_rodjenja")
        private Date datumRodjenja;

        @Column(nullable = false)
        private Boolean aktivan;

        @OneToMany(mappedBy = "clanFitnessCentra", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Ocena> ocenaTermina = new HashSet<>();

        @ManyToMany
        @JoinTable(name="Prisutni",
                joinColumns = @JoinColumn(name = "clan_fitness_centra_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
                private Set<Termin> odradjeniTermini = new HashSet<>();

        @ManyToMany
        @JoinTable(name="Prijavljeni",
                joinColumns = @JoinColumn(name = "clan_fitness_centra_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
        private Set<Termin> prijavljeniTermini = new HashSet<>();

        public ClanFitnessCentra() { }

        public long getId() { return id; }

        public void setId(long id) {
                this.id = id;
        }

        public String getKorisnickoIme() {
                return korisnickoIme;
        }

        public void setKorisnickoIme(String korisnickoIme) {
                this.korisnickoIme = korisnickoIme;
        }

        public String getIme() {
                return ime;
        }

        public void setIme(String ime) {
                this.ime = ime;
        }

        public String getPrezime() {
                return prezime;
        }

        public void setPrezime(String prezime) {
                this.prezime = prezime;
        }

        public String getSifra() {
                return sifra;
        }

        public void setSifra(String sifra) {
                this.sifra = sifra;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getKontaktTelefon() {
                return telefon;
        }

        public void setKontaktTelefon(String kontaktTelefon) {
                this.telefon = kontaktTelefon;
        }

        public Date getDatumRodjenja() {
                return datumRodjenja;
        }

        public void setDatumRodjenja(Date datumRodjenja) {
                this.datumRodjenja = datumRodjenja;
        }

        public Boolean getAktivan() {
                return aktivan;
        }

        public void setAktivan(Boolean aktivan) {
                this.aktivan = aktivan;
        }

        public Set<Ocena> getOcenaTermina() {
                return ocenaTermina;
        }

        public void setOcenaTermina(Set<Ocena> ocenaTermina) {
                this.ocenaTermina = ocenaTermina;
        }

        public Set<Termin> getOdradjeniTermini() {
                return odradjeniTermini;
        }

        public void setOdradjeniTermini(Set<Termin> odradjeniTermini) {
                this.odradjeniTermini = odradjeniTermini;
        }

        public Set<Termin> getPrijavljeniTermini() {
                return prijavljeniTermini;
        }

        public void setPrijavljeniTermini(Set<Termin> prijavljeniTermini) {
                this.prijavljeniTermini = prijavljeniTermini;
        }
}