package de.thws.Prog2.L14;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void testNormal(){
        testPerson("Steffen","Schlosser","Friedenstraße","10","63743","Aschaffenburg");
    }
    @Test
    void testLowerCase1(){
        testPersonFailing("steffen","Schlosser","Friedenstraße","10","63743","Aschaffenburg");
    }
    @Test
    void testLowerCase2(){
        testPersonFailing("Steffen","schlosser","Friedenstraße","10","63743","Aschaffenburg");
    }
    @Test
    void testLowerCase3(){
        testPersonFailing("Steffen","Schlosser","friedenstraße","10","63743","Aschaffenburg");
    }
    @Test
    void testNumber(){
        testPersonFailing("Steffen","Schlosser","Friedenstraße","D10","63743","Aschaffenburg");
    }

    void testPerson(String vorname,String nachname,String strasse, String hausnummer, String postleitzahl, String ort){
        Person p = new Person(vorname,nachname,strasse,hausnummer,postleitzahl,ort);
        assertEquals(vorname,p.vorname);
        assertEquals(nachname,p.nachname);
        assertEquals(strasse,p.adresse.strasse);
        assertEquals(hausnummer,p.adresse.hausnummer);
        assertEquals(postleitzahl,p.adresse.postleitzahl);
        assertEquals(ort,p.adresse.ort);
    }
    void testPersonFailing(String vorname,String nachname,String strasse, String hausnummer, String postleitzahl, String ort){
        try{
            testPerson(vorname,nachname,strasse,hausnummer,postleitzahl,ort);
            fail("Exception Expected");
        }catch (RuntimeException e){
            assertEquals("One of the fields has an unlegitimate value",e.getMessage());
        }
    }
}
