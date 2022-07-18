import command.Command;
import command.CommandFactory;

import enums.CommandEnum;

import util.Help;
import util.Interaction;

public class Main {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Help.printMenu();

        Integer selectedOption = Interaction.takeOption();
        CommandEnum selectedCommand = CommandEnum.fromId(selectedOption);
        Command command = CommandFactory.getCommand(selectedCommand);
        agent.setCommand(command);
        agent.doOperation();
    }
}
