package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interaction {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Integer takeOption() {
        System.out.print("Enter the your selected option : ");
        try {
            String userInput = reader.readLine();
            return Integer.valueOf(userInput);
        } catch (Exception e) {
            throw new RuntimeException("Please Give Valid Number!");
        }
    }
}
