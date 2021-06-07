$(document).ready(function () {
    let uloga = localStorage.getItem("uloga");
    if (uloga == null) {
        localStorage.setItem("uloga", "null");
    }
    if (uloga == "null") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "../index.html";
    }
    if (uloga == "admin") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "../admin/pocetna.html";
    }
    if (uloga == "clan") {
        alert("Nemate pristup ovoj stranici!");
        window.location.href = "../clan/pocetna.html";
    }
});
function logOut(){
    localStorage.setItem("uloga","null");
    window.location.href = "../index.html";
}