package util;

import entity.Record;

import java.util.List;
import java.util.UUID;

public class FileUtil {
    public static void writeToFile(Record record) {
        System.out.println("It was written to file!");
    }

    public static void deleteFromFileById(String id) {
        System.out.println("It was deleted!");
    }

    public static List<String> readAllRawRecords() {
        System.out.println("All records were read");
        return null;
    }
}
