package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdventCodeChallengeTwoTest {
    @Test
    void name() {
        InputStream document = getClass().getClassLoader().getResourceAsStream("trial");
        AdventCodeChallengeTwo adventCodeChallengeTwo = new AdventCodeChallengeTwo();
        List<String> lines = convertInputStreamToList(document);
        ArrayList<String> sums = adventCodeChallengeTwo.bla(lines);
        int result = adventCodeChallengeTwo.blaAndSum(sums);
        System.out.println(result);
    }

    public static List<String> convertInputStreamToList(InputStream inputStream) {
        List<String> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return resultList;
    }

}