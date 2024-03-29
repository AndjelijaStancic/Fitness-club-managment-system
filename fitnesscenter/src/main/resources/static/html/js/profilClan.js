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
    if(uloga=="trener"){
        window.location.href ="../trener/pocetna.html";
    }
    if(uloga=="admin"){
        window.location.href="../admin/pocetna.html";
    }

    idC=localStorage.getItem("id");
    console.log(idC);
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/registracija/podaciClan/"+idC,
        dataType: "json",
        success: function (res){
            console.log(res);
            let datum = res.datumRodjenja.substring(0,10);
            let row = "";
            row += "<tr>"+"<td>IME</td><td>" + res.ime + "</td>"+"</tr>";
            row += "<tr>"+"<td>PREZIME</td><td>" + res.prezime +"</td>"+"</tr>";
            row += "<tr>"+"<td>EMAIL</td><td>" + res.email +"</td>"+"</tr>";
            row += "<tr>"+" <td>KORISNIČKO IME</td><td>" + res.korisnickoIme +"</td>"+"</tr>";
            row += "<tr>"+"<td>TELEFON</td><td>" + res.kontaktTelefon +"</td>"+"</tr>";
            row += "<tr>"+"<td>DATUM ROĐENJA</td><td>" + datum +"</td>"+"</tr>";
            $("#tabela").append(row);

        },
        error: function (res){
            console.log("ERROR:\n", res);
        }

    });
});