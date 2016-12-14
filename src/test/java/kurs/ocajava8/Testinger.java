package kurs.ocajava8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toanders on 09.12.2016.
 */
public class Testinger {

    @Test
    public void test1() {
        String jalla = "ABCDEFGHIJ";
        for (char item : jalla.toCharArray()) {
            System.out.println(item);
        }

        String[] thisIsAStringArray = {"AAA", "BBB", "CCC", "DDD", "EEE"};
        for (String ltr : thisIsAStringArray) {
            System.out.println(ltr);
        }
        String entekst = "Java:is:fun";
        String[] splitter = entekst.split(":");
        System.out.println("Splitter :");
        for (String ltr : splitter) {
            System.out.println(ltr);
        }
    }

    @Test
    public void test2() {
//        String[] args = {"1", "2", "3", "4", "5"};
//        int total = args.length;
//        switch (total) {
//            case 0:
//            case 1:
//            case 2:
//                System.out.println("2 or less");
//                break;
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("5 or less");
//               //FEILER HER continue;
//            default:
//                System.out.println("More than 5");
//        }
        System.out.println("Finished");
    }

    @Test
    public void stringbuilerTest() {
        StringBuilder s = new StringBuilder(2);
        System.out.println("StringBuilder Lengde:"+s.length());
        System.out.println("StringBuilder Kapasitet:"+s.capacity());
    }

    //@Test
    public void forsemikolloneTest() {
       for(; ; ){System.out.println("Tester");}
    }

    @Test
    public void leggetilTest() {
       int a= 1;
       int b=1;

       System.out.println(a=b--);
       System.out.println(b);
    }

    @Test
    public void arrayListTest() {
       ArrayList m = new ArrayList();
       m.add(1);
       m.add(2);
       m.add(3);
       m.remove(1);
       for(Object item : m){
           System.out.println(item);
       }
    }

    @Test
    public void toarrayTest() {
        int[][] myarray = { {1,2,3},
                {4,5},
                {6,7,8}
        };
        System.out.println(myarray[1][1]);
    }
}
