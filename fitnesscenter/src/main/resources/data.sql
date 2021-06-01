INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email) VALUES ('Ultimate Fitness', 'Narodnog fronta 14', '019287392', 'ultimate@gmail.com');
INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email) VALUES ('Healthy Mind', 'Knjaza Milosa 4', '021345323', 'healthy@gmail.com');
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('predrag1', 'Predrag', 'Stankovic', '1234', 'predrag@gmail.com', '1998-05-20', '0644222211', '1','0','2.4',1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('vukann', 'Vukan', 'Petrovic', 'ahsjfas', 'vukan@gmail.com', '2000-03-29', '0641622211', '0','0', '5.9', 1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('kata', 'Katarina', 'Milenkovic', 'ajskdf', 'kata@gmail.com', '2004-04-30', '064423451', '0','0', '2.9', 2);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('isi1', 'Isidora', 'Petrovic', 'akshsjhd', 'isidora@gmail.com', '2003-12-31', '06543456', '0','0', '4.8', 1);
INSERT INTO SALA(kapacitet, oznaka_sale,fitness_centar_id) VALUES ('450', '1', 1);
INSERT INTO SALA(kapacitet, oznaka_sale,fitness_centar_id) VALUES ('220', '2', 1);
INSERT INTO SALA(kapacitet, oznaka_sale,fitness_centar_id) VALUES ('240', '3', 1);
INSERT INTO SALA(kapacitet, oznaka_sale,fitness_centar_id) VALUES ('257', '2', 2);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('stancica_','Andjelija','Stancic','andja123','andjica.stancicc@gmail.com','0603424081','2000-08-05','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('dencica_','Aleksandra','Dencic','akiaki','aleksandra.dencic@gmail.com','066324821','2000-08-05','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('tacaa_','Tamara','Aleksic','tacaa1','tamara.aleksic@gmail.com','0692104220','2000-04-21','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('stepan_','Stepan','Stancic','stepan11','stepan.stancic@gmail.com','0603424089','2000-11-29','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('vasa_','Vasilije','Stancic','vasa123','vasilije.stancic@gmail.com','0603424027','2000-07-02','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('joka_','Jovana','Madic','jolo123','jovana.madic@gmail.com','0603546543','2000-08-19','1');
INSERT INTO ADMINISTRATOR(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('jekica_','Jelisaveta','Stancic','jeka123','jekica.stancic@gmail.com','060444444','2000-06-04','1');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'aerobik');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'individualni', 'krosfit');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('linija', 'individualni', 'boks');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'kardio');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'plivanje');
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-11-09 21:15:00', '2021-11-09 22:45:00', '90', '520',1,1,1);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-11-09 21:15:00', '2021-11-09 22:45:00', '90', '520',2,2,3);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-4-06 09:15:00', '2021-4-06 11:15:00', '120', '1050', 3, 3,2);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-1-07 18:30:00', '2021-1-07 19:30:00', '60', '500', 5, 4,4);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-5-08 13:45:00', '2021-5-08 15:15:00', '90', '700', 4, 3,1);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, trening_id, trener_id, sala_id) VALUES ('2021-7-08 12:30:00', '2021-7-08 14:00:00', '90', '700', 3, 3,1);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('5.0', 1, 1);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.3', 5, 2);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('3.8', 6, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('2.7', 5, 4);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('3.9', 6, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.0', 5, 2);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.5', 1, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.1', 2, 4);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (1,6);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (2,1);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (3,4);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (2,5);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (2,6);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (3,4);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (2,3);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (5,5);





