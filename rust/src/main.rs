use std::alloc::System;
use std::time::{SystemTime, UNIX_EPOCH};

fn main() {
    pizzarechner();
    zeit();
}

fn pizzarechner(){
    let pizza_1_durchmesser:f64 = 10.0;
    let pizza_1_preis:f64 = 7.0;
    let pizza_2_durchmesser:f64 = 7.0;
    let pizza_2_preis:f64 = 5.0;

    let pizza1radius = pizza_1_durchmesser / 2.0;
    let pizza2radius = pizza_2_durchmesser / 2.0;

    let pizza1area = 3.14 *  pizza1radius * pizza1radius;
    let pizza2area = 3.14 * pizza2radius * pizza2radius;

    let pizza1price_per_area = pizza_1_preis / pizza1area;
    let pizza2price_per_area = pizza_2_preis / pizza2area;

    if(pizza2price_per_area > pizza1price_per_area){
        println!("Pizza 1 Kostet {pizza1price_per_area}€/cm² und ist damit preiswerter als Pizza 2 mit {pizza2price_per_area}€/cm²");
    }else{
        println!("Pizza 2 Kostet {pizza1price_per_area}€/cm² und ist damit preiswerter als Pizza 1 mit {pizza1price_per_area}€/cm²");
    }

}

fn zeit(){

    let sec_of_day = (24*60*60);

    let now = SystemTime::now().duration_since(UNIX_EPOCH).expect("error").as_secs();
    let days = now / sec_of_day;

    let elapsed_seconds = now - days*sec_of_day;

    let day_percent = elapsed_seconds as f32 / sec_of_day as f32 * 100.0;
    let seconds_to_midnight = sec_of_day - elapsed_seconds;

    println!("Now        : {now} ");
    println!("Days passed: {days} ");
    println!("Es sind {elapsed_seconds} Sekunden nach Mitternacht");
    println!("Es sind {seconds_to_midnight} Sekunden vor Mitternacht");
    println!("Prozent des Tages: {day_percent}%");

}