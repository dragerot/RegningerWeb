package kurs;


import org.junit.Test;

import java.util.*;

public class Dummy {
    @Test
    public void tallTest(){
      long l = 99_000_000_000L;
      char ch1 = 'G';
      int[] ages = new int[3];
      ages[2]=19;
      String custname="Sally Smith";
      System.out.println("Start with "+custname.startsWith("Sally"));
      custname.contains(".*hallo*.");
      String lc= ("GOOD"+"BYE").toLowerCase();
        String name2 =custname.substring(6);
      String lastname=custname.substring(6,custname.length());
      System.out.println("31 % 6 "+ 31%6);

    }

    @Test
    public void aTest(){
        Map<String,String> mapTest = new HashMap<String,String>();
        mapTest.put("1","A");
        mapTest.put("1","B");

        Set<String> setTest = new HashSet<String>();
        setTest.add("1");
        setTest.add("2");
        setTest.add("2");

    }

    @Test
    public void calcTest(){
        int a =3;
        double b= 3.99;

      System.out.println("Svar:"+ a*2.99);
    }

    @Test
    public void stringTest(){
        String aA="A";
        String AA="AA";
        int tallet = 121212121;
        Number n = 2.0;
        double dd = 3.9;
        int rdd= (int)dd;
        System.out.println("svar "+rdd);

    }

    @Test
    public void StringArrayTest(){
        String [] items ={"A","B","C","D"};
        System.out.println("Hallo "+ items.toString());
        System.out.println("Antall "+items.length);
    }



}
