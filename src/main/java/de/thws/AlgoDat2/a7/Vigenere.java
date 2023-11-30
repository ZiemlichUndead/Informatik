package de.thws.AlgoDat2.a7;

import java.util.Scanner;

public class Vigenere {

//PASSWORDPASSWORDPASSWORDP
//VISIT ME TOMORROW EVENING
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter passphrase: ");
//        String pwd = sc.nextLine();
//        System.out.print("Enter text: ");
//        String input = sc.nextLine();
//        System.out.println("Encrypted: "+encrypt(pwd,input));
        String pwd = "PASSWORD";
        String input = "VISIT ME TOMORROW EVENING";
        String encrypted = encrypt(input,pwd);
        String decrypted = decrypt(encrypted,pwd);
        System.out.println("Plain: "+input);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+decrypted);

    }

    public static String decrypt(String s, String p){
        int[] input = stringToNumbers(s.toLowerCase());
        int[] pwd = stringToNumbers(p.toLowerCase());
        int[] output = new int[s.length()];

        for (int i = 0; i < input.length; i++) {
            output[i] = input[i] - pwd[i%pwd.length];
            if(output[i] < 0){
                output[i] += 26;
            }
        }

        return numbersToString(output);
    }
    public static String encrypt(String s, String p){
        int[] input = stringToNumbers(s.toLowerCase());
        int[] pwd = stringToNumbers(p.toLowerCase());
        int[] output = new int[s.length()];

        for (int i = 0; i < input.length; i++) {
            output[i] = input[i] + pwd[i%pwd.length];
            if(output[i] > 26){
                output[i] -= 26;
            }
        }

        return numbersToString(output);
    }

    public static int letterToNumber(char c){
        if(c == ' '){
            return 0;
        }
        return (int) c - 96;
    }
    public static char numberToLetter(int c){
        if(c == 0){
            return ' ';
        }
        return (char) ((char) c + 96);
    }

    public static int[] stringToNumbers(String s){
        int[] re = new int[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
           re[i] = letterToNumber(c);
           i++;
        }
        return re;
    }

    public static String numbersToString(int[] a){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(numberToLetter(a[i]));
        }
        return sb.toString();
    }

}
