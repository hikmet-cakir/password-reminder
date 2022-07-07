package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interaction {

    private static final BufferedReader reader;

    static {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStreamReader);
    }

    public static Integer takeOption() {
        System.out.print("Enter the your selected option : ");
        try {
            String userInput = reader.readLine();
            return Integer.valueOf(userInput);
        } catch (Exception e) {
            throw new RuntimeException("Please Give Valid Number!");
        }
    }

    public static String takeInformationByGivenValue(String value) {
        System.out.print("Enter the your " + value + ": ");
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Please give valid " + value + "!");
        }
    }
}
