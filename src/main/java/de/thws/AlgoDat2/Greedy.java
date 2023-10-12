package de.thws.AlgoDat2;

import java.util.*;

public class Greedy {

    public static void main(String[] args) {
        money(78, Arrays.asList(50,10,5,2,1));
        money(14, Arrays.asList(11,7,1));
        //Bei 11 cent
    }



    public static void money(int eingabe, List<Integer> coins){

//        List<Integer> coins = new ArrayList<>();
//
//        while(coins.stream().reduce((c1,c2)-> c1+c2).get() < eingabe){
//            if(eingabe)
//        }
//        int fuffies = 0;
//        int zehner = 0;
//        int fuenfer = 0;
//        int zweier = 0;
//        int einer = 0;
//
//        while(eingabe > 0){
//            if(eingabe >= 50){
//                fuffies++;
//                eingabe-=50;
//            }else
//            if(eingabe >= 10){
//                zehner++;
//                eingabe-=10;
//            }else
//            if(eingabe >= 5){
//                fuenfer++;
//                eingabe-=5;
//            }else
//            if(eingabe >= 2){
//                zweier++;
//                eingabe-=2;
//            }else
//            if(eingabe >= 1){
//                einer++;
//                eingabe-=1;
//            }
//        }
//
//        System.out.println("Fuffies: "+fuffies);
//        System.out.println("zehner: "+zehner);
//        System.out.println("fuenfer: "+fuenfer);
//        System.out.println("zweier: "+zweier);
//        System.out.println("einer: "+einer);
//        for (Integer i : returnCoins.keySet()) {
//            System.out.println("Coin "+i+": "+returnCoins.get(i));
//        }

        HashMap<Integer,Integer> returnCoins = new HashMap<>();

        System.out.println("Eingabe: "+eingabe);
        while(eingabe > 0){
            for (Integer coin : coins) {
                if(eingabe >= coin){
                    returnCoins.putIfAbsent(coin,0);
                    returnCoins.put(coin,returnCoins.get(coin)+1);
                    eingabe-=coin;
                    break;
                }
            }
        }

        returnCoins.keySet().stream().sorted(Comparator.reverseOrder()).forEach((coin) ->{
            System.out.println("Coin "+coin+": "+returnCoins.get(coin));
        });

    }

}
