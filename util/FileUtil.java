package util;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String RECORD_FILE_PATH = ".\\passwords.txt";

    private static final String USERS_FILE_PATH = ".\\users.txt";

    public static void writeToFile(String rawRecord) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(RECORD_FILE_PATH), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.append(rawRecord);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("It was written to file!");
        }
    }

    public static void deleteFromFileById(String id) {
        try {
            Path path = Path.of(RECORD_FILE_PATH);
            List<String> rawRecords = Files.readAllLines(path);
            List<String> updatedRawRecords = rawRecords.stream()
                    .filter(rawRecord -> !rawRecord.contains(id))
                    .toList();
            Files.deleteIfExists(path);
            Files.createFile(path);
            updatedRawRecords.forEach(FileUtil::writeToFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readAllRawRecords() {
        try {
            Path path = Path.of(RECORD_FILE_PATH);
            if(!Files.exists(path)) {
                return new ArrayList<>();
            }
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readUserInformation() {
        File file = new File(USERS_FILE_PATH);
        if(!file.exists()) {
            return "";
        }
        try(BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            return reader.readLine();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToUserFile(String rawUser) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(USERS_FILE_PATH), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.append(rawUser);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("It was written to file!");
        }
    }
}
