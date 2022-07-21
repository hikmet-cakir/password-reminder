
import command.Command;
import command.CommandFactory;

import command.CreateUserCommand;
import enums.CommandEnum;

import security.Authentication;
import security.InformationHiding;
import util.Help;
import util.Interaction;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Help.printBanner();
        Agent agent = new Agent();

        boolean hasUser = Authentication.hasUser();
        if(!hasUser) {
            agent.setCommand(new CreateUserCommand());
            agent.doOperation();
        } else {
            String[] credentialInformations = Interaction.takeCredentialInformations();
            boolean hasAccess = Authentication.hasAccess(credentialInformations);
            if (!hasAccess) {
                throw new RuntimeException("Username or password isn't correct!");
            }
        }

        String secretKeyInformation = Interaction.takeSecretKeyInformation();
        if(!secretKeyInformation.isBlank()) {
            InformationHiding.setEncryptionKey(secretKeyInformation);
        }
        Interaction.clearScreen();
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
