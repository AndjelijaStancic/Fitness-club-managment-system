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

    let datum = document.forms['forma'].datum.value;

    let naziv = document.forms['forma'].naziv.value;
    let tip = document.forms['forma'].tip.value;
    let opis= document.forms['forma'].opis.value;


    let kriterijum = {
        sviTermini,
        cena,
        trajanje,
        datum,
        naziv,
        tip,
        opis
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/termini/pretraga",
        dataType: "json",
        contentType:"application/json",
        data: JSON.stringify(kriterijum),
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
                row += "<td class='brisanje'>" + res[i].nazivTreninga + "</td>";
                row += "<td class='brisanje'>" + res[i].tipTreninga + "</td>";
                row += "<td class='brisanje'>" + res[i].opisTreninga + "</td>";



                row += "</tr>";
                $('#termini').append(row);

            }
        },
        error: function (res) {
            console.log("ERROR:\n", res);
        }
    });

});
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

