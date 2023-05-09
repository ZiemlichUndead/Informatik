package de.thws.Prog2.L18;

import java.io.*;

public class A1 {


    public static void splitStudiengaenge(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pw1 = new PrintWriter(new FileWriter("f1.txt"));
        PrintWriter pw2 = new PrintWriter(new FileWriter("f2.txt"));
        PrintWriter pw3 = new PrintWriter(new FileWriter("f3.txt"));

        String line;
        while((line = br.readLine()) != null){
            if(line.startsWith("50")){
                pw1.println(line);
            }
            if(line.startsWith("51")){
                pw2.println(line);
            }
            if(line.startsWith("61")){
                pw3.println(line);
            }
        }

        br.close();
        pw1.close();
        pw2.close();
        pw3.close();
    }

    public static void main(String[] args) {
        try {
            splitStudiengaenge("Test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
