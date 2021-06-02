$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();

    let korisnickoIme = document.forms['prijava'].kime.value;
    let sifra = document.forms['prijava'].sifra.value;
    let uloga = document.forms['prijava'].radio.value;

        let prijava1 = {
            korisnickoIme,
            sifra,
            uloga
        }
        if(uloga ==="Trener"){
            var u=3;
        }
        if(uloga ==="Clan"){
            var u=2;
        }
        console.log(prijava1);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/prijava/"+uloga,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(prijava1),

            success: function (prijava) {
                console.log(prijava);
                if(prijava.allert == true){
                    alert(prijava.poruka);
                }else if(prijava.uloga == 2) {
                    alert(prijava.poruka);
                    window.location.href = "../html/clan/pocetna.html";}
                else {
                    alert(prijava.poruka);
                    window.location.href = "../html/trener/pocetna.html";
                }

            },
            error: function () {
                console.log("ERROR:\n");
                alert("Greška!");
            }
        });
});