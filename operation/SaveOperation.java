package operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Record;

import util.FileUtil;

import java.util.UUID;

public class SaveOperation {

    public void saveRecord(Record record) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        record.setId(uuidAsString);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String rawRecord = mapper.writeValueAsString(record);
            FileUtil.writeToFile(rawRecord);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
