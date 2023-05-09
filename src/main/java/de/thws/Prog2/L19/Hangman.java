package de.thws.Prog2.L19;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    public void hangman(TCPServer server){
        String wort = getRandomWord();

        int tries = 10;

        List<Character> guesses = new ArrayList<>();

        server.write(new Rateversuch(getBlanks(wort),false,false));

        String input;
        while ((input = server.read().substring(0,1)) != null && tries > 1) {


            if(guesses.contains(input.charAt(0))){
//                server.write("Das hast du bereits geraten");
                server.write(new Rateversuch("Das hast du bereits geraten",false,false));
                continue;
            }

            if (!wort.contains(input)) {
                tries--;
//                server.write("Incorrect guess. Tries left: "+tries+" | "+getBlankedWord(wort,guesses));
                server.write(new Rateversuch(getBlankedWord(wort,guesses),false,false));
                continue;
            }

            guesses.add(input.charAt(0));

            if(wort.equalsIgnoreCase(getBlankedWord(wort,guesses))){
                break;
            }

//            server.write(getBlankedWord(wort,guesses));
            server.write(new Rateversuch(getBlankedWord(wort,guesses),false,true));
        }

        if(guesses.size() == wort.length()) {
//            server.write("Du hast das wort erfolgreich geraten!");
            server.write(new Rateversuch(getBlankedWord(wort,guesses),true,true));
        }else{
//            server.write("Du hast keine Versuche mehr. Dead!");
            server.write(new Rateversuch("Du hast keine Versuche mehr. Dead!",true,true));
        }

    }


    public String getBlankedWord(String wort, List<Character> guesses){
        char[] wortChars = wort.toCharArray();
        for (int i = 0; i < wort.length(); i++) {
            if(!guesses.contains(wortChars[i])){
                wortChars[i] = '_';
            }
        }
        return new String(wortChars);
    }



    public String getBlanks(String wort){
        String blanks = "";
        for (int i = 0; i < wort.length(); i++) {
            blanks+="_";
        }
        return blanks;
    }

    public String getRandomWord(){
        return worte[(int) (Math.random()*worte.length)];
    }
    String[] worte = {"Amogus", "Schmamogus","Aschmogus" };

}
