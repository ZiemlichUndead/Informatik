package de.thws.Prog2.L19;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) {
        TCPClient server = new TCPClient();
        server.test();
    }
    public void test() {
        final int PORT = 5000;
        final String HOST = "localhost";
        Scanner s = new Scanner(System.in);

        try (Socket connectionToServer = new Socket(HOST, PORT);
                OutputStream os = connectionToServer.getOutputStream();) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader br = new BufferedReader(new InputStreamReader(connectionToServer.getInputStream()));
            ObjectInputStream ois = new ObjectInputStream(connectionToServer.getInputStream());

            String toServer = "";
            do {
                toServer = s.nextLine();
                bw.write(toServer);
                bw.newLine();
                bw.flush();
                if (!toServer.equals("exit")) {
//                    String line = br.readLine();
//                    System.out.println("From Server: " + line);
                    Rateversuch rateversuch = (Rateversuch) ois.readObject();
                    if(rateversuch.geschafft){
                        System.out.println("Du hast das Wort erraten: "+rateversuch.blankedWort);
                        return;
                    }
                    if(rateversuch.treffer){
                        System.out.println(rateversuch.blankedWort);
                        continue;
                    }
                    System.out.println("Das war leider falsch: "+rateversuch.blankedWort);

                }
            } while (!toServer.equals("exit"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        s.close();
    }
}