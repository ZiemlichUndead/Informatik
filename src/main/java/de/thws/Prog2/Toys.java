package de.thws.Prog2;

public class Toys {


    public static void main(String[] args){
        Bird b = new Bird();
        b.eat();
        b.fly();

        Pig p = new Pig();
        b.eat();
    }
    public static class Toy{

    }
    public static class Animal extends Toy{
        public void eat(){
            if(this instanceof Bird){
                System.out.println("Pick");

            }else if(this  instanceof Pig){
                System.out.println("Nom");
            }
        }
    }
    public static class Bird extends Animal{
        public void fly(){
            System.out.println("Flying");
        }

    }

    public static class Pig extends Animal {
        public void grunt(){

        }
    }
    public static class Robot extends Toy{
        public void beep(){

        }
    }
}
