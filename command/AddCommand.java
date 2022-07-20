package command;

import entity.Record;

import operation.SaveOperation;

import security.InformationHiding;
import util.Interaction;


public class AddCommand implements Command {
    @Override
    public void execute() {
        String location = Interaction.takeInformationByGivenValue("Location (PayPal, Amazon, Apple)");
        String accountId = Interaction.takeInformationByGivenValue("Account ID");
        String password = Interaction.takeInformationByGivenValue("Password");

        SaveOperation saveOperation = new SaveOperation();
        Record record = new Record(location, accountId, password);
        saveOperation.saveRecord(record);
        Interaction.clearScreen();
    }
}
