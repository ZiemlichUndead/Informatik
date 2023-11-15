window.addEventListener("load",function (e){

    document.getElementById("calc").addEventListener("click", function (e) {
        e.preventDefault();
        var birthDate = new Date(document.getElementById("birthdate").value);
        var now = Date.now();

        const diffTime = Math.abs(now - birthDate);
        const diffYears = Math.floor(diffTime / (1000 * 60 * 60 * 24 * 365));

        document.getElementById("ageOutput").innerHTML="Your age is: "+diffYears;
    });
});

// if ("serviceWorker" in navigator) {
//     navigator.serviceWorker.register("sw.js");
// }
