$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();
    let naziv = document.forms['fitnes'].naziv.value;
    let adresa = document.forms['fitnes'].adresa.value;
    let brojTelefona = document.forms['fitnes'].broj.value;
    let email= document.forms['fitnes'].emailadresa.value;
    let dodaj = {
        naziv,
        adresa,
        brojTelefona,
        email
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/dodaj/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(dodaj),
        success: function (fitnes) {
            console.log("SUCCESS:\n", fitnes);
            alert("Uspešno ste dodali fitness centar");
            window.location.href = "pocetna.html";
        },
        error: function () {
            console.log("ERROR:\n");
            alert("Greška!");
        }
    });
});