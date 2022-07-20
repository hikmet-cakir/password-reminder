package operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Record;

import security.InformationHiding;
import util.FileUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FindOperation {

    public List<Record> findAllRecords() {
        List<String> allRawRecords = FileUtil.readAllRawRecords();
        List<Record> allRecords = allRawRecords.stream()
                .map(this::rawRecordToRecord)
                .collect(Collectors.toList());
        allRecords.forEach(this::exposeHiddenRecordInformations);
        return allRecords;
    }

    private void exposeHiddenRecordInformations(Record record) {
        record.setPassword(InformationHiding.decrypt(record.getPassword()));
        record.setAccountId(InformationHiding.decrypt(record.getAccountId()));
        record.setLocation(InformationHiding.decrypt(record.getLocation()));
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
