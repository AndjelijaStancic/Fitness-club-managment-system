function logOut(){
    localStorage.setItem("uloga","null");
    window.location.href = "../index.html";
}
$(document).ready(function () {
    let uloga = localStorage.getItem("uloga");
    if (uloga == null) {
        localStorage.setItem("uloga", "null");
        window.location.href = "../index.html";
    }
    if (uloga == "null") {
        window.location.href = "../index.html";
    }
    if (uloga == "clan") {
        window.location.href = "../clan/pocetna.html";
    }
    if (uloga == "trener") {
        window.location.href = "../trener/pocetna.html";
    }

});
$(document).on("submit", "form", function (event) {

    event.preventDefault();
    let naziv = document.forms['fitnes'].naziv.value;
    let adresa = document.forms['fitnes'].adresa.value;
    let brojTelefona = document.forms['fitnes'].broj.value;
    let email= document.forms['fitnes'].emailadresa.value;

    let menjaj = {
        naziv,
        adresa,
        brojTelefona,
        email
    }
    promenaCentar = localStorage.getItem("promenaCentar");
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/dodajfitnes/menjaj/"+ promenaCentar,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(menjaj),
        success: function (fitnes) {
            console.log("SUCCESS:\n", fitnes);
            alert("Uspešno ste izmenili Fitness Centar!");
            window.location.href = "centri.html";
        },
        error: function () {
            console.log("ERROR:\n");
            console.log(promenaCentar);
            alert("Greška!");
        }
    });

});

