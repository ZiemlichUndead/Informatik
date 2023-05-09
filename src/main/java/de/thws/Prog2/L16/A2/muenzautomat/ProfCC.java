package de.thws.Prog2.L16.A2.muenzautomat;

public class ProfCC implements ChangeCalculator{

    public int[] getChange(int euros, int cents)
    {
        cents = euros * 100 + cents;
        return new int[]
                {
                        cents % 200 % 100 % 50 % 20 % 10 % 5 % 2 / 1,
                        cents % 200 % 100 % 50 % 20 % 10 % 5 / 2,
                        cents % 200 % 100 % 50 % 20 % 10 / 5,
                        cents % 200 % 100 % 50 % 20 / 10,
                        cents % 200 % 100 % 50 / 20,
                        cents % 200 % 100 / 50,
                        cents % 200 / 100,
                        cents / 200
                };
    }

}
