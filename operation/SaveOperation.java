package operation;

import entity.Record;
import util.FileUtil;

import java.util.UUID;

public class SaveOperation {

    public void saveRecord(Record record) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        record.setId(uuidAsString);
        FileUtil.writeToFile(record);
    }
}
