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
        url: "http://localhost:8080/api/dodajfitnes/svicentri/",
        dataType: "json",
        success: function (res){

            for(i=0 ; i<res.length; i++){
                let list = "<option value='"+ res[i].id + "'>" +  res[i].id + "</option>"  ;
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
        let uloga =  localStorage.getItem("uloga");
// ajax poziv
        event.preventDefault();
        let oznakaSale = document.forms['fitnes'].oznakaSale.value;
        let kapacitet = document.forms['fitnes'].kapacitet.value;
        let active = true;
        let idFC = document.forms['fitnes'].dropdownlist.value;
        let dodaj = {
            oznakaSale,
            kapacitet,
            active,
            idFC
        }
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/dodajsalu/dodajS/"+uloga,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(dodaj),
            success: function (fitnes) {
                console.log("SUCCESS:\n", fitnes);
                alert("Uspešno ste dodali salu u fitness centar!");
            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });

});