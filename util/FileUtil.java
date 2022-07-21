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

    private static final String FILE_PATH = ".\\passwords.txt";

    public static void writeToFile(String rawRecord) {
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.append(rawRecord);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("It was written to file!");
        }
    }

    public static void deleteFromFileById(String id) {
        try {
            Path path = Path.of(FILE_PATH);
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
            Path path = Path.of(FILE_PATH);
            if(!Files.exists(path)) {
                return new ArrayList<>();
            }
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
