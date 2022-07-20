package command;

import entity.Record;

import operation.FindOperation;

import java.util.List;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        FindOperation findOperation = new FindOperation();
        List<Record> allRecords = findOperation.findAllRecords();
        System.out.format("%20s %35s %30s %30s \n", "ID", "LOCATION", "ACCOUNT ID", "PASSWORD");
        allRecords.forEach(record ->
                System.out.printf("%s %17s %45s %18s \n", record.getId(), record.getLocation(), record.getAccountId(), record.getPassword()));
    }
}
