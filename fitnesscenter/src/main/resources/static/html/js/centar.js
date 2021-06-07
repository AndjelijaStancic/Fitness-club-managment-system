function logOut(){
    localStorage.setItem("uloga","null");
    window.location.href = "../index.html";
}
$(document).ready(function (){
    let uloga =  localStorage.getItem("uloga");
    if(uloga == null){
        localStorage.setItem("uloga","null");
        window.location.href ="../index.html";
    }
    if(uloga == "null"){
        window.location.href ="../index.html";
    }
    if(uloga=="clan"){
        window.location.href ="../clan/pocetna.html";
    }
    if(uloga=="trener"){
        window.location.href="../trener/pocetna.html";
    }
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
        url: "http://localhost:8080/api/dodajfitnes/dodaj/"+uloga,
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
});