package Training.A4;

public class Zielort {

    String name;
    int distance;
    Zielort next;



    public Zielort(String name, int distance) {
        this.name = name;
        this.distance = distance;

    }


    public String toString() {
        return "Hallo";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
