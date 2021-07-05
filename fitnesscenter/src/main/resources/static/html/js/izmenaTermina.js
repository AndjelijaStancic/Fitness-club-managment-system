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
    if(uloga=="admin"){
        window.location.href="../admin/pocetna.html";
    }
    idTrenera=localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/dodajsalu/sale/"+idTrenera,
        dataType: "json",
        success: function (res){

            for(i=0 ; i<res.length; i++){
                let list = "<option value='"+ res[i].id + "'>" +  res[i].oznakaSale + "</option>"  ;
                $("#dropdownlist").append(list);
            }
        },
        error: function (res){
            console.log("ERROR:\n", res);
        }

    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/dodajfitnes/svitren/"+uloga,
        dataType: "json",
        success: function (res){

            for(i=0 ; i<res.length; i++){
                let list = "<option value='"+ res[i].id + "'>" +  res[i].nazivTreninga + " / " + res[i].tipTreninga + " / " + res[i].opisTreninga + "</option>"  ;
                $("#dropdownlist1").append(list);
            }
        },
        error: function (res){
            console.log("ERROR:\n", res);
        }

    });




});

$(document).on("submit", "form", function (event) {
    let uloga =  localStorage.getItem("uloga");
// ajax poziv
    event.preventDefault();
    let datum = document.forms['termin1'].datum.value;
    if(datum == "" || datum == null){
        datum = "2000-8-5";
    }
    let pocetak = document.forms['termin1'].pocetak.value;
    let pocetakTermina = datum;
    pocetakTermina += "T";
    pocetakTermina += pocetak;
    pocetakTermina += ":00";
    let kraj = document.forms['termin1'].kraj.value;
    let krajTermina = datum;
    krajTermina += "T";
    krajTermina += kraj;
    krajTermina += ":00";
    let cenaTermina = document.forms['termin1'].cena.value;
    if(cenaTermina == "" || isNaN(cenaTermina)){
        cenaTermina = -1;
    }
    let idSale = document.forms['termin1'].dropdownlist.value;
    if(idSale == ""){
        idSale = -1;
    }
    let idTreninga = document.forms['termin1'].dropdownlist1.value;
    if(idTreninga == ""){
        idTreninga = -1;
    }
    let idTrenera = localStorage.getItem("id");

    let satiPocetak = pocetak.substring(0,2);
    let satiKraj = kraj.substring(0,2);
    let minutiPocetak = pocetak.substring(3,5);
    let minutiKraj = kraj.substring(3,5);
    let trajanjeTermina = (Number(satiKraj)-Number(satiPocetak))*60;
    trajanjeTermina += (Number(minutiKraj)-Number(minutiPocetak));

    let menjaj = {
        pocetakTermina,
        krajTermina,
        trajanjeTermina,
        cenaTermina,
        idSale,
        idTreninga,
        idTrenera
    }


    promenaTermin = localStorage.getItem("promenaTermin");

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/promeniTermin/"+promenaTermin,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(menjaj),
        success: function (res) {
            console.log("SUCCESS:\n", res);
            if(res.trajanjeTermina == -2){
                alert(res.nazivTreninga);
                window.location.href = "../../index.html";
            } else if (res.trajanjeTermina == -1){
                alert(res.nazivTreninga);
            } else {
                alert("Uspešno ste izmenili termin!");
                window.location.href = "terminiTrener.html";
                console.log(res.trajanjeTermina);
            }


        },
        error: function () {
            console.log("ERROR:\n");
            alert("Greška!");
        }
    });

});