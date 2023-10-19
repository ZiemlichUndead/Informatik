'use strict';

function Car (typ, vendor, model, cubic, power, color, damaged) {
    this.typ = typ;
    this.vendor = vendor;
    this.model = model;
    this.cubic = cubic;
    this.power = power;
    this.color = color;
    this.damaged = damaged;
}

var cars = [];
window.addEventListener("load",function (e){

    document.getElementById("form").addEventListener("submit", function (e) {
        e.preventDefault();

        var formData = new FormData(document.getElementById("form"));
        // output as an object
        // console.log(Object.fromEntries(formData));

        // // ...or iterate through the name-value pairs
        // for (var pair of formData.entries()) {
        //     console.log(pair[0] + ": " + pair[1]);
        // }
        cars.push(new Car(formData.get("typ"),
            formData.get("vendor"),
            formData.get("model"),
            formData.get("cubic"),
            formData.get("power"),
            formData.get("color"),
            formData.get("damaged")
            ))
    });

    document.getElementById("print").addEventListener("click", function (e) {
        e.preventDefault();
        var output = "Cars: ";

        var i = 1;
        cars.forEach(function (car) {
            output += "\nCar "+i+": \n";
            output += " Vendor: "+car.vendor+"\n";
            output += " Model: "+car.model+"\n";
            output += " Cubic: "+car.cubic+"\n";
            output += " Power: "+car.power+"\n";
            // output += " Color: "+ntc.name(car.color)+"\n";
            output += " Color: "+car.color+"\n";
            output += " Damage: "+car.damaged+"\n";

            i++;
        })
        alert(output);
    })


});

// const vendor = {
//     PKW: 'PKW',
//     LKW: 'LKW',
//     Motorrad: 'Motorrad',
//     Trike: 'Trike',
//     Quad: 'Quad'
// };
//
// const Damaged = {
//     CrashFree: 'Crash free',
//     Repaired: 'Repaired',
//     Damaged: 'Damaged'
// };

