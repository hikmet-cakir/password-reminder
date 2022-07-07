import command.Command;
import command.CommandFactory;

import util.Help;
import util.Interaction;

public class Main {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Help.printMenu();

        Integer selectedOption = Interaction.takeOption();
        Command command = CommandFactory.getCommand(selectedOption);
        agent.setCommand(command);
        agent.doOperation();
    }
}
