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
});

$(document).on("submit", "form", function (event) {
// ajax poziv
    event.preventDefault();
    let tohide = $(".brisanje");
    tohide.hide();
    let sviTermini = document.forms['forma'].radio.value;
    if(sviTermini=="kriterijum"){
        sviTermini=false;
    }else{
        sviTermini=true;
    }
    console.log(sviTermini);
    let cena = document.forms['forma'].maksimalnaCena.value;
    if(isNaN(cena) || cena == ""){
        cena=9000000;
    }
    let trajanje = document.forms['forma'].maksimalnoTrajanje.value;
    if( isNaN(trajanje) || trajanje == "" ){
        trajanje=9000000;
    }
    let mesec=9000000;

    let naziv = document.forms['forma'].naziv.value;
    let tip = document.forms['forma'].tip.value;
    let opis= document.forms['forma'].opis.value;


    let kriterijum = {
        sviTermini,
        cena,
        trajanje,
        mesec,
        naziv,
        tip,
        opis
    }
idC = localStorage.getItem("id");
    $.ajax({
        type: "POST",                                                // HTTP metoda
        url: "http://localhost:8080/api/termini/pretraga/"+idC,                   // URL koji se gađa
        dataType: "json",
        contentType:"application/json",
        data: JSON.stringify(kriterijum),
        success: function (res) {                                   // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", res);                         // ispisujemo u konzoli povratnu vrednost
            for (i = 0; i < res.length; i++) {
                let pocetakTermina=res[i].pocetakTermina;
                let krajTermina=res[i].krajTermina;
                let row = "<tr>";
                row += "<td class='brisanje'>" + res[i].id + "</td>";
                row += "<td class='brisanje'>" + pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td>";
                row += "<td class='brisanje'>" + krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td>";
                row += "<td class='brisanje'>" + res[i].trajanjeTermina + "</td>";
                row += "<td class='brisanje'>" + res[i].cenaTermina + "</td>";
                row += "<td class='brisanje'>" + res[i].nazivTreninga + "</td>";
                row += "<td class='brisanje'>" + res[i].tipTreninga + "</td>";
                row += "<td class='brisanje'>" + res[i].opisTreninga + "</td>";
                let informacije = "<button id='info' data-id=" + res[i].id + "> VIŠE INFORMACIJA</button>";
                row += "<td class='brisanje'>" + informacije + "</td>";
                row += "</tr>";
                $('#termini').append(row);

            }
        },
        error: function (res) {                                     // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", res);
        }
    });

});

$(document).on('click', '#info', function (){

    let flush = $("#moreInfo");
    flush.empty();
    let show = $("#infoDiv");
    show.show();

    let idTermina = this.dataset.id;

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/termini/info/" + idTermina,
        dataType: "json",
        success: function (res){

                let pocetakTermina=res.pocetakTermina;
                let krajTermina=res.krajTermina;

                let row = "<tr><th>ID:</th><td>"+ res.id + "</td></tr>";
                row += "<tr><th>Pocetak:</th><td>"+ pocetakTermina.substring(0,10) + " " + pocetakTermina.substring(11,16) + "</td></tr>";
                row += "<tr><th>Kraj:</th><td>"+ krajTermina.substring(0,10) + " " + krajTermina.substring(11,16) + "</td></tr>";
                row += "<tr><th>Trajanje:</th><td>"+ res.trajanjeTermina + "</td></tr>";
                row += "<tr><th>Cena:</th><td>"+ res.cenaTermina + "</td></tr>";
                row += "<tr><th>Naziv:</th><td>"+ res.nazivTreninga + "</td></tr>";
                row += "<tr><th>Tip:</th><td>"+ res.tipTreninga + "</td></tr>";
                row += "<tr><th>Opis:</th><td>"+ res.opisTreninga + "</td></tr>";
                row += "<tr><th>Oznaka sale:</th><td>"+ res.oznakaSale + "</td></tr>";
                row += "<tr><th>Fitnes centar:</th><td>"+ res.fitnesCentar + "</td></tr>";
                row += "<tr><th>Trener:</th><td>"+ res.korisnickoTrener + "</td></tr>";
                row += "<tr><th>Ocena trenera:</th><td>"+ res.ocenaTrenera + "</td></tr>";
                row += "<tr><th>Popunjenost:</th><td>"+ res.prijavljeni + "/" + res.kapacitet + "</td></tr>";
                row += "<tr><th>Prijava:</th><td>"+ "<button id='prijava' data-id=" + res.id + "> PRIJAVI SE</button>" + "</td></tr>";


                $("#moreInfo").append(row);

        },
        error: function (res){
            //console.log(uloga);
            //console.log(res.length);
            console.log("ERROR:\n", res);
        }

    });



});

$(document).on('click', '#prijava', function (){



    let idTermina = this.dataset.id;
    let idClana = localStorage.getItem("id");

    let prijava = {
        idTermina,
        idClana
    }

    $.ajax({
        type: "POST",                                                // HTTP metoda
        url: "http://localhost:8080/api/termini/prijava/",                   // URL koji se gađa
        dataType: "json",
        contentType:"application/json",
        data: JSON.stringify(prijava),
        success: function (res) {                                   // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", res);                         // ispisujemo u konzoli povratnu vrednost
            if(res.retVal == -1){
                alert("Nema mesta na ovom terminu!");
            } else {
                alert("Uspesno ste se prijavili na termin!");
                let flush = $("#moreInfo");
                flush.empty();
                let show = $("#infoDiv");
                show.hide();
                window.location.href = "terminClan.html";
            }
        },
        error: function (res) {                                     // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", res);
        }
    });



});

function zatvoriDiv(){
    let flush = $("#moreInfo");
    flush.empty();
    let hide = $("#infoDiv");
    hide.hide();
}

function sortiraj(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("termini");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i = 1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */

            if (dir == "asc") {
                if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}
function sortirajBr(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("termini");
    switching = true;
    // Set the sorting direction to ascending:
    dir = "asc";
    /* Make a loop that will continue until
    no switching has been done: */
    while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
        first, which contains table headers): */
        for (i =1; i < (rows.length - 1); i++) {
            // Start by saying there should be no switching:
            shouldSwitch = false;
            /* Get the two elements you want to compare,
            one from current row and one from the next: */
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];

            /* Check if the two rows should switch place,
            based on the direction, asc or desc: */
            let prvi = x.innerHTML.toLowerCase();
            let drugi = y.innerHTML.toLowerCase();
            if (dir == "asc") {
                if (Number(prvi) > Number(drugi)/* x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            } else if (dir == "desc") {
                if (Number(prvi) < Number(drugi)/* x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase() */) {
                    // If so, mark as a switch and break the loop:

                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /* If a switch has been marked, make the switch
            and mark that a switch has been done: */
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            // Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /* If no switching has been done AND the direction is "asc",
            set the direction to "desc" and run the while loop again. */
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}