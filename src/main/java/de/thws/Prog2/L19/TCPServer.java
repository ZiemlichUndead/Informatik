package de.thws.Prog2.L19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    BufferedReader br;
    BufferedWriter bw;

    ObjectOutputStream oos;

    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        server.test();
    }
    public void test() {

        final int PORT = 5000;

        try (ServerSocket ss = new ServerSocket(PORT);
             Socket connection = ss.accept();
             InputStream is = connection.getInputStream();
             OutputStream os = connection.getOutputStream();
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            this.br = br;
            this.bw = bw;
            this.oos = oos;

            String vomClient = "";

            vomClient = br.readLine();
            if(!vomClient.equalsIgnoreCase("start")){
                return;
            }
            Hangman h = new Hangman();
            h.hangman(this);
//            do {
//                vomClient = br.readLine();
//                System.out.println(vomClient);
//                bw.write("OK");
//                bw.newLine();
//                bw.flush();
//            } while (!vomClient.equals("exit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write(Rateversuch rateversuch){
        try {
            oos.writeObject(rateversuch);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void write(String line){
        try {
            bw.write(line);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read(){
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}