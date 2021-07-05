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

idT=localStorage.getItem("id");
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/termini/sviTrener/"+idT,
    dataType: "json",
    success: function (res) {
        console.log("SUCCESS:\n", res);
        for (i = 0; i < res.length; i++) {
            let pocetakTermina=res[i].pocetakTermina;
            let krajTermina=res[i].krajTermina;
            let row = "<tr>";
            row += "<td class='brisanje'>" + res[i].id + "</td>";
            row += "<td class='brisanje'>" + pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td>";
            row += "<td class='brisanje'>" + krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td>";
            row += "<td class='brisanje'>" + res[i].trajanjeTermina + "</td>";
            row += "<td class='brisanje'>" + res[i].cenaTermina + "</td>";
            row += "<td class='brisanje'>" + res[i].tipTreninga + "</td>";
            row += "<td class='brisanje'>" + res[i].opisTreninga + "</td>";
            row += "<td class='brisanje'>" + res[i].oznakaSale + "</td>";
            let changeButton = "<button id='change' data-id=" + res[i].id + "> IZMENI</button>";
            let deleteButton = "<button id='delete' data-id=" + res[i].id + "> OBRIŠi</button>";
            row += "<td class='brisanje'>" + changeButton + "</td>";
            row += "<td class='brisanje'>" + deleteButton + "</td>";


            row += "</tr>";
            $('#tabela').append(row);

        }
    },
    error: function (res) {
        console.log("ERROR:\n", res);
        console.log(idT);
    }
});
});
$(document).on('click', '#change',function (){
    let idTermin = this.dataset.id;
    localStorage.setItem("promenaTermin", idTermin);
    window.location.href = "izmenaTermina.html";
});