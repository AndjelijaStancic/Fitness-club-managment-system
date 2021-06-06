/*$(document).ready(function () {
    let uloga = localStorage.getItem("uloga");
    if (uloga == null) {
        localStorage.setItem("uloga", "null");
    }
    if (uloga === "admin") {
        alert("Vec ste prijavljeni!");
        window.location.href = "../html/admin/pocetna.html";
    }
    if (uloga === "clan") {
        alert("Vec ste prijavljeni!");
        window.location.href = "../html/clan/pocetna.html";
    }
    if (uloga === "trener") {
        alert("Vec ste prijavljeni!");
        window.location.href = "../html/trener/pocetna.html";
    }
});
*/
$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();

    let korisnickoIme = document.forms['prijava'].kime.value;
    let sifra = document.forms['prijava'].sifra.value;
    let role = document.forms['prijava'].radio.value;

        let prijava1 = {
            korisnickoIme,
            sifra,
            role
        }
        if(role ==="Trener"){
            var uloga="trener";
        }
        if(role ==="Clan"){
            var uloga="clan";
        }
        if(role ==="Admin"){
            var uloga="admin";
        }

        console.log(prijava1);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/prijava/"+role,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(prijava1),

            success: function (prijava) {
                console.log(prijava);
                if(prijava.allert == true){
                    console.log(uloga);
                    alert(prijava.poruka);
                }else if(prijava.uloga == 2) {
                    console.log(uloga);
                    localStorage.setItem("uloga","clan");
                    alert(prijava.poruka);
                    window.location.href = "../html/clan/pocetna.html";}
                else if(prijava.uloga ==3){
                    localStorage.setItem("uloga","trener");
                    alert(prijava.poruka);
                    window.location.href = "../html/trener/pocetna.html";
                }else{
                    localStorage.setItem("uloga","admin");
                    alert(prijava.poruka);
                    window.location.href = "../html/admin/pocetna.html";
                }

            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });
});
