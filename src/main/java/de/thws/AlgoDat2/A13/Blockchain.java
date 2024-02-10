package de.thws.AlgoDat2.A13;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Blockchain<T> {


    public static void main(String[] args) {
        Blockchain<String> chain = new Blockchain<>();

        for (int i = 0; i < 20; i++) {
            chain.addBlock(generateRandomString(7));
        }
//        System.out.println(chain);
    }

    List<Block<T>> blocks = new ArrayList<>();

    public void addBlock(T data){
        Block<T> nblock;
        if(blocks.isEmpty()){
            nblock = new Block<T>(0, System.currentTimeMillis(),null,hash("000000".getBytes()),data);
        }else{
            Block<T> pblock = blocks.get(blocks.size()-1);
             nblock = new Block<T>(pblock.count + 1, System.currentTimeMillis(),null,hash(pblock.toString().getBytes()),data);
        }
        setPoW(nblock);
        blocks.add(nblock);
        System.out.println(new String(hash(nblock.toString().getBytes())));
    }
    void setPoW(Block<T> block){
        byte[] start_seq = new byte[3];
        start_seq[0] = -1;
        for (int i = 0; i < start_seq.length; i++) {
            if(start_seq[i] != '0'){
                block.nonce = generateRandomString(8);
                byte[] h = hash(block.toString().getBytes());
//                System.out.println(new String(h));
                start_seq = Arrays.copyOfRange(h,0,start_seq.length);
                i = 0;
            }
        }
    }

    public byte[] hash(byte[] data){

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return digest.digest(data);
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "blocks=" + blocks +
                '}';
    }

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = new Random().nextInt(CHAR_LOWER.length());
            char rndChar = CHAR_LOWER.charAt(rndCharAt);

            // debug
//            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }


    static class Block<T>{
        int count;
        long timestamp;

        String nonce;
        byte[]  prev_hash;

        T data;

        public Block(int count, long timestamp, String nonce, byte[] prev_hash, T data) {
            this.count = count;
            this.timestamp = timestamp;
            this.nonce = nonce;
            this.prev_hash = prev_hash;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "count=" + count +
                    ", timestamp=" + timestamp +
                    ", nonce='" + nonce + '\'' +
                    ", prev_hash=" + Arrays.toString(prev_hash) +
                    ", data=" + data +
                    '}';
        }
    }
}
