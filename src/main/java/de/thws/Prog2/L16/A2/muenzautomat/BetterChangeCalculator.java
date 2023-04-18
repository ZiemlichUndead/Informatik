package de.thws.Prog2.L16.A2.muenzautomat;

public class BetterChangeCalculator implements ChangeCalculator{
    @Override
    public int[] getChange(int euros, int cent) {
        int allCents = euros*100+cent;
        int[] change = new int[8];

        Coin[] coins = Coin.values();

        for (int i = coins.length-1; i > 0; i--) {
            int coinCount = allCents / coins[i].value;
            change[i] += coinCount;
            allCents -= coinCount * coins[i].value;
        }

        return change;

    }

    public static void main(String[] args) {
        ChangeCalculator cc = new BetterChangeCalculator();
        ChangeCalculator pcc = new ProfCC();
        cc.getChange(0,0);
        pcc.getChange(0,0);

        long begin = System.nanoTime();
        cc.getChange(100, 68);
        long end = System.nanoTime();
        System.out.println("Normal: "+(end - begin));

        long begin1 = System.nanoTime();
        pcc.getChange(100,68);
        long end1 = System.nanoTime();
        System.out.println("Prof: "+(end1 - begin1));

//        for (int i = 0; i < change.length; i++) {
//            System.out.println(change[i]);
//        }
    }

}
