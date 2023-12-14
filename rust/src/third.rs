use std::fs::File;
use std::{fs, io};
use std::io::Write;
use std::path::Path;

struct Car2 {
    brand: String,
    model: String,
    year: Option<u32>,
    color: String,
}

#[cfg(test)]
mod tests{
    use crate::third::get_weekday;

    #[test]
    fn test() {
        assert_eq!(get_weekday(0),String::from("Montag"));
        assert_eq!(get_weekday(1),String::from("Dienstag"));
        assert_eq!(get_weekday(2),String::from("Mittwoch"));
        assert_eq!(get_weekday(3),String::from("Donnerstag"));
        assert_eq!(get_weekday(4),String::from("Freitag"));
        assert_eq!(get_weekday(5),String::from("Samstag"));
        assert_eq!(get_weekday(6),String::from("Sonntag"));
    }
    #[test]
    #[should_panic]
    fn test_err(){
        get_weekday(7);
    }
}

pub(crate) fn third(){
    let car1 = Car2 {
        brand: String::from("Toyota"),
        model: String::from("Camry"),
        year: Some(2020),
        color: String::from("Blue"),
    };
    let car2 = Car2 {
        brand: String::from("Ford"),
        model: String::from("Mustang"),
        year: Some(2015),
        color: String::from("Red"),
    };
    let car3 = Car2 {
        brand: String::from("Ford"),
        model: String::from("Fokus"),
        year: None,
        color: String::from("Lila"),
    };
    let car4 = Car2 {
        brand: String::from("Opel"),
        model: String::from("Astra"),
        year: None,
        color: String::from("Red"),
    };
    let car5 = Car2 {
        brand: String::from("Audi"),
        model: String::from("R9"),
        year: Some(2050),
        color: String::from("Pürpel"),
    };

    let test: [Car2;5] = [car1,car2,car3,car4,car5];
    print_autos(&test);

}

fn print_autos(arr: &[Car2]){

    for car in arr {
        if(car.year.is_none()){
            println!("Car: {:?} {:?} {:?} ",car.brand,car.color,car.color);
        }
    }

}

pub(crate) fn test_weekday(){
    print!("{:?}",get_weekday(0));
    print!("{:?}",get_weekday(7));

}

fn get_weekday(i: i32) -> String{
     match i {
         0 => {String::from("Montag")},
         1 => {String::from("Dienstag")},
         2 => {String::from("Mittwoch")},
         3 => {String::from("Donnerstag")},
         4 => {String::from("Freitag")},
         5 => {String::from("Samstag")},
         6 => {String::from("Sonntag")},
         _ =>  {panic!("Tag nicht gefunden")}
     }
}

pub(crate) fn hello(){
    print!("Wie heißt du: \n");

    let mut buffer = String::new();
    let stdin = io::stdin(); // We get `Stdin` here.
    stdin.read_line(&mut buffer).expect("TODO: panic message");
    let text = String::from("Hallo ") + &*buffer;

    let path = Path::new("hello.txt");
    match fs::metadata(path) {
        Ok(_) => panic!("File exists!"),
        Err(_) => println!("File does not exist yet"),
    }

    let mut file = match File::create("hello.txt") {
        Err(why) => panic!("couldn't create {}", why),
        Ok(file) => file,
    };

    print!("{:?}",text);

    file.write_all(text.as_ref()).unwrap();


}