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

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static String takeContinueRequest() {
        System.out.print("Do you want to do another thing?(Yes(y)/No(n):");
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Please give valid value!");
        }
    }

    public static String[] takeCredentialInformations() {
        try {
            System.out.print("Username:");
            String username = reader.readLine();

            System.out.print("Password:");
            String password = reader.readLine();
            return new String[] {username, password};
        } catch (Exception e) {
            throw new RuntimeException("Please give valid value!");
        }
    }

    public static String takeSecretKeyInformation() {
        try {
            System.out.print("Please give your secret key information:");
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Please give valid value!");
        }
    }
}
