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

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/dodajfitnes/svicentri/" + uloga,
        dataType: "json",
        success: function (res){

            for(i=0 ; i<res.length; i++){
                let list = "<option value='"+ res[i].id + "'>" +  res[i].naziv + "</option>"  ;
                $("#dropdownlist").append(list);
            }
            for(i=0 ; i<res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].id + "</td>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "</tr>"
                $("#tfcentri").append(row);
            }
        },
        error: function (res){
            console.log("ERROR:\n", res);
        }
    });
});
function prikaziCentre(){
    let tabela = $("#fcentar");
    tabela.show();
}
function sakrijCentre(){
    let tabela = $("#fcentar");
    tabela.hide();
}


$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();

    let ime = document.forms['reg'].ime.value;
    let prezime = document.forms['reg'].prezime.value;
    let email = document.forms['reg'].email.value;
    let korisnickoIme = document.forms['reg'].korisnickoime.value;
    let kontaktTelefon = document.forms['reg'].kontakttelefon.value;
    let datumRodjenja = document.forms['reg'].datumRodjenja.value;
    let sifra = document.forms['reg'].sifra.value;
    let proveraSifre = document.forms['reg'].proveraSifre.value;
    let idfc = document.forms['reg'].dropdownlist.value;

    if(idfc == ""){
        alert("Morate izabrati id centra u kom želite da trener radi!");
        return false;
    }

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
            sifra,
            idfc
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/registracija/TrenerAdmin/",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(registracija),

            success: function (res) {
                console.log("SUCCESS:\n", res);
                alert("Dodavanje uspešno!");
                window.location.href="pocetna.html";


            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });
    }
});
