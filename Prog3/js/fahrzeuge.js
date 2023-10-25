'use strict';

function Vehicle (typ, vendor, model, cubic, power, color, damaged) {
    this.typ = typ;
    this.vendor = vendor;
    this.model = model;
    this.cubic = cubic;
    this.power = power;
    this.color = color;
    this.damaged = damaged;
}


function LKW (typ, vendor, model, cubic, power, color, damaged, lagerraum) {
    Vehicle.call(this,typ, vendor, model, cubic, power, color, damaged);
    this.lagerraum = lagerraum;

}
// Object.setPrototypeOf(LKW.prototype, Vehicle.prototype);


var cars = [];
window.addEventListener("load",function (e){

    document.getElementById("form").addEventListener("submit", function (e) {
        e.preventDefault();

        var formData = new FormData(document.getElementById("form"));
        cars.push(new Vehicle(formData.get("typ"),
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

