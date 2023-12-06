package org.example;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventCodeChallengeTwo {

    public ArrayList<String> bla(List<String> document2) {
        var sums = new ArrayList<String>();
        for (String s : document2) {
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

    private int leftToRight(String s) {
        String s2 = extractNumbersInLetters(s);
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        throw new RuntimeException("keine Ziffer in der Zeile:" + s2);
    }


    private int rightToLeft(String s) {
        String s2 = extractNumbersInLetters(s);
        for (int i = s2.length() - 1; i >= 0; i--) {
            char c = s2.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }

            }
        throw new RuntimeException("keine Ziffer in der Zeile:" + s);
    }
    public static String extractNumbersInLetters(String input) {
       input = input.toLowerCase();
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
        StringBuilder result = new StringBuilder();
        int i = 0;
        int inputLength = input.length();
        boolean foundMatch = false;
        Iterator<Map.Entry<String, Integer>> iterator = wordToNumberMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String word = entry.getKey();
            int wordLength = word.length();

            if (i + wordLength <= inputLength && input.startsWith(word, i)) {
                result.append(entry.getValue());
                i += wordLength;
                foundMatch = true;
                break;
            }
        }

            // If no match is found or the current character is not a letter, keep it
            if (i < inputLength && !Character.isLetter(input.charAt(i))) {
                result.append(input.charAt(i));
                i++;
            }

        return result.toString();
    }
}

