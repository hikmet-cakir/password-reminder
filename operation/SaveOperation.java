package operation;

import entity.Record;

import util.FileUtil;

public class SaveOperation {

    public void saveRecord(Record record) {
        Integer generatedId = 123;
        record.setId(generatedId);
        FileUtil.writeToFile(record);
    }
}
