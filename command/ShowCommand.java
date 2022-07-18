package command;

import entity.Record;

import operation.FindOperation;

import java.util.List;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        FindOperation findOperation = new FindOperation();
        List<Record> allRecords = findOperation.findAllRecords();
        System.out.format("%15s %40s %35s %40s%n", "ID", "LOCATION", "ACCOUNT ID", "PASSWORD");
        allRecords.forEach(record ->
                System.out.format("%s %15s %50s %30s%n", record.getId(), record.getLocation(), record.getAccountId(), record.getPassword()));
    }
}
