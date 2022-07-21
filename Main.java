import command.Command;
import command.CommandFactory;

import enums.CommandEnum;

import security.InformationHiding;
import util.Help;
import util.Interaction;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Help.printBanner();

        String secretKeyInformation = Interaction.takeSecretKeyInformation();
        if(!secretKeyInformation.isBlank()) {
            InformationHiding.setEncryptionKey(secretKeyInformation);
        }
        Interaction.clearScreen();

        Agent agent = new Agent();
        while(true) {
            Help.printMenu();
            Integer selectedOption = Interaction.takeOption();
            Interaction.clearScreen();
            CommandEnum selectedCommand = CommandEnum.fromId(selectedOption);
            Command command = CommandFactory.getCommand(selectedCommand);
            agent.setCommand(command);
            agent.doOperation();
            String hasAnotherRequest = Interaction.takeContinueRequest();
            if(hasAnotherRequest.trim().toLowerCase(Locale.ROOT).contains("no") ||
                    hasAnotherRequest.trim().toLowerCase(Locale.ROOT).contains("n")) {
                break;
            }
        }
    }
}
