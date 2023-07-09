package de.thws.Prog2.training;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class A2 {

    public static class User implements Serializable {
        public final String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public interface ObjectManager<T>{
        public void serialize(List<T> object);
        public List<T> deserialize();
    }

    public static class UserManager implements ObjectManager<User>{

        String filename = "user.dat";
        @Override
        public void serialize(List<User> users){
            try {
                FileOutputStream fos = new FileOutputStream(filename);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(users);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public List<User> deserialize(){
            try {
                FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                return (List<User>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Message{
        public String msg;
        public LocalDate date;

        public Message(String msg) {
            if(msg.length() > 140){
                msg = msg.substring(0,139);
            }

            this.msg = msg;
            this.date = LocalDate.now();
        }

        @Override
        public String toString() {
            return "Message{" +
                    "msg='" + msg + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
    public static class TwotterSystem{

        HashMap<User,List<Message>> messages = new HashMap<>();
        public void addMessage(User user, Message msg){
            messages.putIfAbsent(user,new ArrayList<>());
            messages.get(user).add(msg);
        }

        public List<Message> getAllMessages(){
            return messages.keySet().stream().flatMap(user -> messages.get(user).stream()).toList();
        }

        public List<Message> getAllMessagesFromDate(String date){
            List<Message> allMessages = getAllMessages();
            LocalDate ddate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return allMessages.stream().filter(message -> message.date.equals(ddate)).toList();
        }
        public List<Message> getAllMessagesFromUser(User u){
            return messages.get(u);
        }

    }


    public static void main(String[] args) {
        TwotterSystem ts = new TwotterSystem();
        User user1 = new User("123","3455");
        User user2 = new User("1234","34555");

        ts.addMessage(user1,new Message("Hello Welt"));
        ts.addMessage(user2,new Message("Hello Welle"));
//
//        ts.getAllMessages().forEach(System.out::println);
//        ts.getAllMessagesFromUser(user1).forEach(System.out::println);
//        ts.getAllMessagesFromUser(user2).forEach(System.out::println);

        ts.getAllMessagesFromDate("2023-07-09").forEach(System.out::println);




    }

}
