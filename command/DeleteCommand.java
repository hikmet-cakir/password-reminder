package command;

import operation.DeleteOperation;

import util.Interaction;

public class DeleteCommand implements Command {
    @Override
    public void execute() {
        String recordId = Interaction.takeInformationByGivenValue("Record's ID").trim();
        DeleteOperation deleteOperation = new DeleteOperation();
        deleteOperation.deleteById(recordId);
        Interaction.clearScreen();
    }
}
