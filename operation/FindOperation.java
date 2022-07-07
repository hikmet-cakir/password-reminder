package operation;

import entity.Record;
import util.FileUtil;

import java.util.List;
import java.util.UUID;

public class FindOperation {

    public List<Record> findAllRecords() {
        List<String> allRawRecords = FileUtil.readAllRawRecords();
        Record mockRecordOne = new Record(UUID.randomUUID().toString(), "PayPal","elizabeth.jackson@hotmail.com", "8432Ohio123");
        Record mockRecordTwo = new Record(UUID.randomUUID().toString(), "GitHub","elizabeth-jackson", "32123412");
        Record mockRecordThree = new Record(UUID.randomUUID().toString(), "Amazon", "elizabethjacksonbavaria@outlook.com", "bavaria123");
        return List.of(mockRecordOne, mockRecordTwo, mockRecordThree);
    }
}
