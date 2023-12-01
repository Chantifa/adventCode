package org.example;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventCodeChallengeTwo {

    public ArrayList<String> bla(List<String> document2) {
        var sums = new ArrayList<String>();
        for (String s : document2) {
            int first = leftToRight(s);
            int word = getWordtoNumber(s);
            int last = rightToLeft(s);
            String sum = null;
            if(first != 0 && word !=0) {
                sum = String.valueOf(first) + String.valueOf(word);
            }
            else if(word != 0 && last !=0) {
                sum = String.valueOf(word) + String.valueOf(last);
            }
            else {
                sum = String.valueOf(first) + String.valueOf(last);
            }
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
            c = c + a;
        }
        return c;
    }

    private int getWordtoNumber(String line) {
        ArrayList<String> wordValues = extractNumbersInLetters(line);
        String sumOfi = null;
        for (String j : wordValues) {
            sumOfi = sumOfi + j;
        }
        return Integer.parseInt(sumOfi);
    }

    private int leftToRight(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            } else {

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


    public static ArrayList<String> extractNumbersInLetters(String input) {
        ArrayList<String> numbersInLetters = new ArrayList<>();

        // Regular expression to match numbers written in letters
        input = input.toLowerCase(); // Convert input to lowercase for case-insensitive matching
        // Add more words and their numeric values as needed
        Map<String, Integer> wordToNumberMap = new HashMap<>();
        wordToNumberMap.put("one", 1);
        wordToNumberMap.put("two", 2);
        wordToNumberMap.put("three", 3);
        wordToNumberMap.put("four", 4);
        wordToNumberMap.put("five", 5);
        wordToNumberMap.put("six", 6);
        wordToNumberMap.put("seven", 7);
        wordToNumberMap.put("eight", 8);
        wordToNumberMap.put("nine", 9);
        wordToNumberMap.put("ten", 10);
        // Find all matches
        Iterator map = wordToNumberMap.entrySet().iterator();
        while (map.hasNext()) {

            String word = wordToNumberMap.entrySet().iterator().next().getKey();
            String number = wordToNumberMap.entrySet().iterator().next().getValue().toString();
            if (input.contains(word)) {
                numbersInLetters.add(number);
                System.out.println(numbersInLetters);
            }
        }

        return numbersInLetters;
    }
}

