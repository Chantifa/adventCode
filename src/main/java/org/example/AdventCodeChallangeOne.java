package org.example;

import java.util.ArrayList;
import java.util.List;

public class AdventCodeChallangeOne {

    public ArrayList<String> bla(List<String> document) {
        var sums = new ArrayList<String>();

        for (String s : document) {
            int first = leftToRight(s);
            int last = rightToLeft(s);
            String sum = String.valueOf(first) + String.valueOf(last);
            sums.add(sum);
        }
        System.out.println(sums);
        return sums;
    }

    public int blaAndSum(List<String> listOfStrings) {
        ArrayList<String> bla = bla(listOfStrings);
        System.out.println(summieren(bla));
        return summieren(bla);
            }

    private int summieren(List<String> listOfString) {
        int c = 0;
        for (String s : listOfString) {
            int a = Integer.parseInt(s);
            c = c+a;
        }
        return c;
    }

    private int leftToRight(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        throw new RuntimeException("keine Ziffer in der Zeile:" + s);
    }

    private int rightToLeft(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        throw new RuntimeException("keine Ziffer in der Zeile:" + s);
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}