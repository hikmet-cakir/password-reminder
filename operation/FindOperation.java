package operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Record;

import util.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FindOperation {

    public List<Record> findAllRecords() {
        List<String> allRawRecords = FileUtil.readAllRawRecords();
        return allRawRecords.stream()
                .map(this::rawRecordToRecord)
                .collect(Collectors.toList());
    }

    private Record rawRecordToRecord(String rawRecord) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(rawRecord, Record.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
