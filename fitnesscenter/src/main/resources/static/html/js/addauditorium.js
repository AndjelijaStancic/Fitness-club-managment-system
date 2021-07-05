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
        url: "http://localhost:8080/api/dodajfitnes/svicentri/"+uloga,
        dataType: "json",
        success: function (res){

            for(i=0 ; i<res.length; i++){
                let list = "<option value='"+ res[i].id + "'>" +  res[i].naziv + "</option>"  ;
                $("#dropdownlist").append(list);
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
        if(oznakaSale == "" || isNaN(oznakaSale)){
            alert("Oznaka sale mora biti broj!");
            return false;
        }
        if(kapacitet == "" || isNaN(kapacitet) || kapacitet<1){
            alert("Kapacitet sale mora biti pozitivan broj!");
            return false;
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
                window.location.href = "sale.html";
            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });

});