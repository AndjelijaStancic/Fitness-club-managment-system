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
        url: "http://localhost:8080/api/registracija/zahtevi/"+uloga,
        dataType: "json",
        success: function (res){
            for(i=0 ; i<res.length; i++){
                let row ="<tr id =\"row" + res[i].id + "\">"
                    + "<td>" + res[i].ime + "</td>"
                    + "<td>" + res[i].prezime + "</td>"
                    + "<td>" + res[i].email + "</td>"
                    + "<td>" + res[i].korisnickoIme + "</td>"
                    + "<td>" + res[i].kontaktTelefon + "</td>"
                    + "<td>" + " <button id = \"approve\" type = \"submit\" data-id=" + res[i].id + ">APPROVE</button>"
                    + " <button id = \"reject\" type = \"submit\" data-id=" + res[i].id + ">REJECT</button>" + "</td>"
                    + "</tr>";
                $("#tabela").append(row);
            }
        },
        error: function (res){
            console.log(uloga);
            console.log(res.length);
            console.log("ERROR:\n", res);
        }

    });



});
$(document).on('click', '#approve',function (){

   let trenerId = this.dataset.id;
   let toHide = $("#row"+ trenerId);
   toHide.hide();

    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/registracija/approve/" + trenerId,
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

    $(document).on('click', '#reject',function (){

        let trenerId = this.dataset.id;
        let toHide = $("#row"+ trenerId);
        toHide.hide();

        $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/registracija/reject/" + trenerId,
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
function logOut(){
    localStorage.setItem("uloga","null");
    window.location.href = "../index.html";
}
