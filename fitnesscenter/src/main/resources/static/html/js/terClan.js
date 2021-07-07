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
    if(uloga=="admin"){
        window.location.href ="../admin/pocetna.html";
    }
    if(uloga=="trener"){
        window.location.href="../trener/pocetna.html";
    }
    let idClana = localStorage.getItem("id");
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/termini/proveri/" + idClana,
        dataType: "json",
        contentType: "application/json",
        success: function (res) {
            console.log("SUCCESS:\n", res);
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });
});
$(document).on('click', '#oceni', function (){

    let show = $("#ocenaDiv");
    show.show();

    let idTermina = this.dataset.id;
    let obrisi = $("#row"+ idTermina);
    obrisi.hide();
    localStorage.setItem("terminZaOcenjivanje", idTermina);
});
$(document).on('click', '#odjaviSe', function (){

    let idTermina = this.dataset.id;
    let obrisi = $("#row"+ idTermina);
    obrisi.hide();
    console.log(obrisi);
    let idClana = localStorage.getItem("id");
    let odjava = {
        idTermina,
        idClana
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/odjava/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(odjava),
        success: function (res) {
            console.log("SUCCESS:\n", res);
            alert("Uspešno ste se odjavili sa termina!");
            
        },
        error: function () {
            console.log("ERROR:\n");
            alert("Greška!");
        }
    }); 

});

function prijavljeni(){

    let flush = $("#sadrzaj");
    flush.empty();
    $("#ocena").hide();
    $("#oceni").hide();
    $("#odjavi").show();


    let idClana = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/prijavljeni/" + idClana,
        dataType: "json",
        success: function (res){
            for (i = 0; i < res.length; i++) {
                    let pocetakTermina=res[i].pocetakTermina;
                    let krajTermina=res[i].krajTermina;
                    let row = "<tr id='row" + res[i].id + "'>";
                    row += "<td>" + res[i].id + "</td>";
                    row += "<td>" + pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td>";
                    row += "<td>" + krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td>";
                    
                    row += "<td>" + res[i].cenaTermina + "</td>";
                    row += "<td>" + res[i].opisTreninga + "</td>";
                    row += "<td>" + res[i].korisnickoTrener + "</td>";
                    let informacije = "<button id='odjaviSe' data-id=" + res[i].id + "> ODJAVI SE</button>";
                    row += "<td>" + informacije + "</td>";
                    row += "</tr>";


                $("#sadrzaj").append(row);
            }

        },
        error: function (res){
            console.log("ERROR:\n", res);
        }

    });
}

function ocenjeni(){
    let flush = $("#sadrzaj");
    flush.empty();
    $("#ocena").show();
    $("#oceni").hide();
    $("#odjavi").hide();
    let idClana = localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/ocenjeni/" + idClana,
        dataType: "json",
        success: function (res){

            for (i = 0; i < res.length; i++) {
                    let pocetakTermina=res[i].pocetakTermina;
                    let krajTermina=res[i].krajTermina;
                    let row = "<tr>";
                    row += "<td>" + res[i].id + "</td>";
                    row += "<td>" + pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td>";
                    row += "<td>" + krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td>";
                    
                    row += "<td>" + res[i].cenaTermina + "</td>";
                    row += "<td>" + res[i].opisTreninga + "</td>";
                    row += "<td>" + res[i].korisnickoTrener + "</td>";
                    row += "<td>" + res[i].ocenaTrenera + "</td>";
                    row += "</tr>";
                    

                


                $("#sadrzaj").append(row);
            }

        },
        error: function (res){
            //console.log(uloga);
            //console.log(res.length);
            console.log("ERROR:\n", res);
        }

    });
}

function neocenjeni(){
    let flush = $("#sadrzaj");
    flush.empty();
    $("#ocena").hide();
    $("#oceni").show();
    $("#odjavi").hide();
    let idClana = localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/neocenjeni/" + idClana,
        dataType: "json",
        success: function (res){

            for (i = 0; i < res.length; i++) {
                    let pocetakTermina=res[i].pocetakTermina;
                    let krajTermina=res[i].krajTermina;
                    let row = "<tr>";
                    row += "<td>" + res[i].id + "</td>";
                    row += "<td>" + pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td>";
                    row += "<td>" + krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td>";
                    
                    row += "<td>" + res[i].cenaTermina + "</td>";
                    row += "<td>" + res[i].opisTreninga + "</td>";
                    row += "<td>" + res[i].korisnickoTrener + "</td>";
                    let informacije = "<button id='oceni' data-id=" + res[i].id + "> OCENI </button>";
                    row += "<td>" + informacije + "</td>";
                    row += "</tr>";
                    

                


                $("#sadrzaj").append(row);
            }

        },
        error: function (res){
            //console.log(uloga);
            //console.log(res.length);
            console.log("ERROR:\n", res);
        }

    });
}

$(document).on("submit", "form", function (event) {
    let idClana =  localStorage.getItem("id");
    let idTermina =  localStorage.getItem("terminZaOcenjivanje");
// ajax poziv
    event.preventDefault();
    let ocena = document.forms['ocenaForm'].vol.value;
    

    let ocenaPack = {
        prosecnaOcena : ocena,
        idClana,
        idTermina
    }
    console.log(ocenaPack);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/ocene/nova/",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ocenaPack),
        success: function (res) {
            console.log("SUCCESS:\n", res);
            alert("Uspešno ste ocenili termin!");
            
        },
        error: function () {
            console.log("ERROR:\n");
            alert("Greška!");
        }
    }); 
    zatvoriDiv();
    

});

function zatvoriDiv(){
    
    let hide = $("#ocenaDiv");
    hide.hide();
}