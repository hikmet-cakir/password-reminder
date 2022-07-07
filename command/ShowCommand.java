package command;

import entity.Record;

import operation.FindOperation;

import java.util.List;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        FindOperation findOperation = new FindOperation();
        List<Record> allRecords = findOperation.findAllRecords();
        System.out.println(allRecords);
    }
}
