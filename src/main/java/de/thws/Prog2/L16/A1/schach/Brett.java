package de.thws.Prog2.L16.A1.schach;

public class Brett
{
  boolean[][] brett = new boolean[8][8];

  public Brett()
  {

  }

  public void markiereFeld(int x, int y)
  {
    if(x < 1 || x > 8 || y < 1|| y > 8){
      return;
    }
    brett[x-1][y-1] = true;
  }

  public boolean gibFeld(int x, int y)
  {
    return brett[x-1][y-1];
  }

  public Brett kombiniere(Brett other){
    boolean[][] b1 = brett;
    boolean[][] b2 = other.brett;

    Brett result = new Brett();

    for (int i = 0; i < b1.length; i++) {
      for (int i1 = 0; i1 < b1[i].length; i1++) {
        result.brett[i][i1] = b1[i][i1] || b2[i][i1];
      }
    }
    return result;
  }

}
