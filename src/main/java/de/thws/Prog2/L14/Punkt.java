package de.thws.Prog2.L14;

public class Punkt
{
    int x;
    int y;
    public void verschiebePunkt(int zielX, int zielY) {

        if(zielX<0||zielY<0||zielX>1920||zielY>1080)
            throw new RuntimeException("Point out of bounds");

        x = zielX;
        y = zielY;

    }
}