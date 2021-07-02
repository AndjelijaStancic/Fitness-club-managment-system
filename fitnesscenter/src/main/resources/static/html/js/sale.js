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

    console.log(uloga);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/dodajsalu/svi/"+uloga,
        dataType: "json",
        success: function (res){
            for(i=0 ; i<res.length; i++){
                //console.log(res[i].kapacitet);
                //console.log(res[i].oznakaSale);
                //console.log(res[i].idFC);
               // console.log(res[i].id);
                let row ="<tr id =\"row" +   "\">"
                    + "<td>" + res[i].oznakaSale + "</td>"
                    + "<td>" + res[i].kapacitet + "</td>"
                    + "<td>" + res[i].idFC + "</td>"
                    + "<td>" + " <button id = \"change\" type = \"submit\" data-id=" + res[i].id + ">IZMENI</button>" + "</td>"
                    + "<td>" +" <button id = \"delete\" type = \"submit\" data-id=" + res[i].id + ">OBRISI</button>" + "</td>"
                    + "</tr>";
                $("#tabela").append(row);
            }
        },
        error: function (res){
            //console.log(uloga);
            //console.log(res.length);
            console.log("ERROR:\n", res);
        }

    });

});
$(document).on('click', '#delete',function (){
let idS = this.dataset.id;
$.ajax({
    type: "PUT",
    url: "http://localhost:8080/api/dodajsalu/obrisi/" + idS,
    dataType: "json",
    contentType: "application/json",
    success: function (res) {
        console.log("SUCCESS:\n", res);
        alert("Uspešno obrisano!");
        console.log(idS);
        window.location.href="sale.html";
    },
    error: function (res) {
        console.log("ERROR:\n", res);
    }
});
});
function logOut(){
    localStorage.setItem("uloga","null");
    window.location.href = "../index.html";
}