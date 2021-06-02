$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();

    let ime = document.forms['reg'].ime.value;
    let prezime = document.forms['reg'].prezime.value;
    let email = document.forms['reg'].email.value;
    let korisnickoIme = document.forms['reg'].korisnickoime.value;
    let kontaktTelefon = document.forms['reg'].kontakttelefon.value;
    let datumRodjenja = document.forms['reg'].datumRodjenja.value;
    let radioButton = document.forms['reg'].radio.value;
    let sifra = document.forms['reg'].sifra.value;
    let proveraSifre = document.forms['reg'].proveraSifre.value;

    if(sifra !== proveraSifre) {
        alert("Šifre se ne podudaraju!");
        return false;
    } else {

        let registracija = {
            ime,
            prezime,
            email,
            korisnickoIme,
            kontaktTelefon,
            datumRodjenja,
            sifra

        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/registracija/"+radioButton,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(registracija),

            success: function (res) {
                console.log("SUCCESS:\n", res);
                alert("Registracija uspešna");
                window.location.href = "prij.html";

            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });
    }
});






