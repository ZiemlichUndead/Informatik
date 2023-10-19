document.getElementById("calc_pi").addEventListener ('click', quadrat, true);

function quadrat(){
    var numberOfRectangels = 1000000

    var area = 0;
    for(var i = 0; i < numberOfRectangels; ++i){
        area += Math.sqrt(1.0 - Math.pow(i/numberOfRectangels, 2))/numberOfRectangels;
    }

    var pi = 4*area;

    document.getElementById("pi_result").innerHTML = "PI is: "+pi;
}