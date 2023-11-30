use std::time::SystemTime;

struct Car {
    brand: String,
    model: String,
    year: u32,
    color: String,
}
trait racing_start{
    fn wheel_spin(&self) -> i32;
}
impl racing_start for Car {
    fn wheel_spin(&self) -> i32 {
        let spin_time_seconds = 3;

        println!("Die Räder drehen {} Sekunden lang durch.", spin_time_seconds);

        spin_time_seconds
    }
}



fn bmw_car_factory(modell_in: String, farbe_in: String) -> Car {
    let current_year = SystemTime::now()
        .duration_since(SystemTime::UNIX_EPOCH)
        .expect("Time went backwards")
        .as_secs() as u32;

    Car {
        brand: String::from("BMW"),
        model: modell_in,
        year: current_year,
        color: farbe_in,
    }
}

fn main() {
    let car1 = Car {
        brand: String::from("Toyota"),
        model: String::from("Camry"),
        year: 2020,
        color: String::from("Blue"),
    };

    let mut car2 = Car {
        brand: String::from("Ford"),
        model: String::from("Mustang"),
        year: 2015,
        color: String::from("Red"),
    };

    car2.year += 10;

    let bmw_car1 = bmw_car_factory(String::from("x4"), String::from("grün"));
    let bmw_car2 = bmw_car_factory(String::from("m4"), String::from("pechschwarz"));
    let bmw_car3 = bmw_car_factory(String::from("m187"), String::from("schwarz"));

    // Erstellen Sie zwei weitere Autos, die genau dem dritten Auto entsprechen
    let car4 = Car{..bmw_car3};
    let car5 = Car{..bmw_car2};

    let racing_start_seconds = bmw_car1.wheel_spin();
    println!("{}", racing_start_seconds)



}