package Training;

import java.util.Scanner;

public class A2 {

    public static class SpaceInvaders{

        String[] spielfeld = new String[5];
        int shipPos = 0;


        public void init(){
            spielfeld[0] = "oooooooo";
            spielfeld[1] = "       ";
            spielfeld[2] = "       ";
            spielfeld[3] = "       ";

            shipPos = (int) (Math.random() * 7);
            setShipPos(shipPos);
        }

        public void setShipPos(int pos){
            if(pos > 7 || pos < 0)return;

            char[] shipRow = "        ".toCharArray();
            shipRow[pos] = 'v';
            spielfeld[4] = new String(shipRow);
            shipPos = pos;
        }

        public void bewege(char c){

            if(c == 'a'){
                setShipPos(shipPos-1);
            }
            if(c == 'd'){
                setShipPos(shipPos+1);
            }

        }

        @Override
        public String toString(){
            String res = "";
            for(int i = 0; i<5;i++){
                String row = spielfeld[i];
                for(char c : row.toCharArray()){
                    res = res+c+" ";
                }
                res = res+"\n";
            }

            return res;
        }

        public static void main(String[] args){
            SpaceInvaders game = new SpaceInvaders();
            game.init();
            System.out.println(game);

            Scanner sc = new Scanner(System.in);

            while(true){
                char input = sc.next().charAt(0);
                if(input == 'x') return;
                game.bewege(input);
                System.out.println(game);
            }

        }
    }



}
