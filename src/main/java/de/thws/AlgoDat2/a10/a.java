package de.thws.AlgoDat2.a10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class a {

    static void buildMerkleRoot(String dir) throws IOException, NoSuchAlgorithmException {
        File[] files = new File(dir).listFiles();

        Arrays.sort(files, Comparator.comparing(File::getName));

        List<byte[]> hashes = new ArrayList<>();
        for(File f : files){
            BufferedReader br = new BufferedReader(new FileReader(f));
            String txt = br.readLine();
            hashes.add(txt.getBytes());
        }

        while(hashes.size() > 1){
            hashes = calc(hashes);
        }

        System.out.println(new String(hashes.get(0)));
        //e4

    }

    static List<byte[]> calc(List<byte[]> hashes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        List<byte[]> newHashes = new ArrayList<>();
        for (int i = 0; i < hashes.size(); i+=2) {
            byte[] hash1 = digest.digest(hashes.get(i));
            byte[] hash2 = digest.digest(hashes.get(i+1));

            String res = hex(hash1)+hex(hash2);
            newHashes.add(res.getBytes());

        }
        return newHashes;
    }

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        buildMerkleRoot("rfiles");
    }
}
