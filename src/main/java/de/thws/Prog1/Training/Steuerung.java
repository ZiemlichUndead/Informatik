package Training;

public class Steuerung {


    Knoten start;
    public static void main(String[] args) {



    }

    public void insert(Knoten k){
        if(k.nachname.compareTo(start.nachname) < 0 ){
            k.right = start;
            start = k;
            return;
        }

        Knoten current = start;
        while(current.nachname.compareTo(start.nachname) < 0){
            current = current.right;
        }
    }
}
