INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email, active) VALUES ('Ultimate Fitness', 'Narodnog fronta 14', '019287392', 'ultimate@gmail.com', 1);
INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email, active) VALUES ('Healthy Mind', 'Knjaza Milosa 4', '021345323', 'healthy@gmail.com',1);
INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email, active) VALUES (' Atleta', 'Vuk KAradzic 3', '0769564853', 'atleta@gmail.com', 1);
INSERT INTO FITNESS_CENTAR(naziv, adresa, broj_telefona, email, active) VALUES ('Total Gym', 'Vojvodjanska 3', '0974859475', 'total@gmail.com',1);

INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('predrag1', 'Predrag', 'Stankovic', '1234', 'predrag@gmail.com', '1998-05-20', '0644222211', '1','0','2.0',1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('vukann', 'Vukan', 'Petrovic', '1234', 'vukan@gmail.com', '2000-03-29', '0641622211', '1','0', '2.0', 1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('kata', 'Katarina', 'Milenkovic', '1234', 'kata@gmail.com', '2004-04-30', '064423451', '1','0', '2.0', 2);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('isi1', 'Isidora', 'Petrovic', '1234', 'isidora@gmail.com', '2003-12-31', '06543456', '1','0', '2.0', 1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('ljubica', 'Ljubica', 'Stankovic', '1234', 'ljub@gmail.com', '1998-05-20', '0642322211', '0','0','2.0',1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('katarina', 'Katarina', 'Stankovic', '1234', 'kat@gmail.com', '2000-03-29', '12345667', '0','0', '2.0', 1);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('sara', 'Sara', 'Milenkovic', '1234', 'sara@gmail.com', '2004-04-30', '064423251', '0','0', '2.0', 2);
INSERT INTO TRENER(korisnicko_ime, ime, prezime, sifra, email, datum_rodjenja, telefon, aktivan,obrisan, prosecna_ocena, fitness_centar_id) VALUES ('marija', 'Marija', 'Petrovic', '1234', 'mara@gmail.com', '2003-12-31', '06545656', '0','0', '2.0', 2);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('450' ,'1',0 , 1);;
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('100' ,'321',0 ,2 );
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('2' ,'222',1 , 2);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('220', '8',1, 1);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('240', '54', 0,3);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('257', '70',1 ,4);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('500', '4',1 ,1);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('30', '5',1 ,4);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('43', '21',1 ,3);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('21', '45',1 ,2);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('20', '33',1 ,1);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('30', '57',1 ,2);
INSERT INTO SALA(kapacitet, oznaka_sale, active,fitness_centar_id) VALUES ('32' ,'59',0 , 1);
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('stancica_','Andjelija','Stancic','andja123','andjica.stancicc@gmail.com','0603424081','2000-08-05 12:00:00','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('dencica_','Aleksandra','Dencic','akiaki','aleksandra.dencic@gmail.com','066324821','2000-10-17 12:00:00','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('tacaa_','Tamara','Aleksic','tacaa1','tamara.aleksic@gmail.com','0692104220','2000-04-21 12:00:00','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('stepan_','Stepan','Stancic','stepan11','stepan.stancic@gmail.com','0603424089','2000-11-29 12:00:00','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('vasa_','Vasilije','Stancic','vasa123','vasilije.stancic@gmail.com','0603424027','2000-07-02 12:00:00','1');
INSERT INTO CLAN_FITNESS_CENTRA(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('joka_','Jovana','Madic','jolo223','jovana.madic@gmail.com','0603546543','2000-08-19 12:00:00','1');
INSERT INTO ADMINISTRATOR(korisnicko_ime, ime, prezime, sifra, email, telefon, datum_rodjenja, aktivan) VALUES ('jekica_','Jelisaveta','Stancic','jeka123','jekica.stancic@gmail.com','060444444','2000-06-04','1');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'aerobik');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'individualni', 'krosfit');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('linija', 'individualni', 'boks');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'kardio');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'grupni', 'plivanje');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'krosfit');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'individualni', 'plivanje');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('linija', 'grupni', 'kardio');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('linija', 'individualni', 'kardio');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'grupni', 'plivanje');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('mrsavljenje', 'individualni', 'krosfit');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'grupni', 'plivanje');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('snaga', 'individualni', 'plivanje');
INSERT INTO TRENING(naziv, tip_treninga, opis) VALUES ('linija', 'grupni', 'boks');
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2020-11-09 21:15:00', '2020-11-09 22:45:00', '90', '520',1,1,1,1);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2020-11-09 21:15:00', '2020-11-09 22:45:00', '90', '520',1,2,2,3);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2020-4-06 09:15:00', '2020-4-06 11:15:00', '120', '1050',1, 3, 3,2);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2022-1-07 18:30:00', '2022-1-07 19:30:00', '60', '500',1, 5, 1,4);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2022-5-08 13:45:00', '2022-5-08 15:15:00', '90', '700',1, 4, 1,1);
INSERT INTO TERMIN(pocetak_termina, kraj_termina, trajanje_termina, cena_termina, active,trening_id, trener_id, sala_id) VALUES ('2022-7-08 12:30:00', '2022-7-08 14:00:00', '90', '700',1, 3, 3,1);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('5.0', 3, 1);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.3', 5, 2);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('3.8', 6, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('2.7', 5, 4);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('3.9', 6, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.0', 5, 2);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.5', 1, 3);
INSERT INTO OCENA(ocena, termin_id, clan_fitness_centra_id) VALUES ('4.1', 2, 4);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (1,1);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (1,2);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (2,1);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (2,2);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (3,1);
INSERT INTO PRISUTNI(termin_id, clan_fitness_centra_id) VALUES (3,2);

INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (6,2);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (5,2);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (5,4);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (4,3);
INSERT INTO PRIJAVLJENI(termin_id, clan_fitness_centra_id) VALUES (5,5);





