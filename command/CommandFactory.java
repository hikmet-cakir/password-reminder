package command;

import enums.CommandEnum;

public class CommandFactory {

    public static Command getCommand(CommandEnum command) {
        switch (command) {
            case ADD_COMMAND : return new AddCommand();
            case DELETE_COMMAND : return new DeleteCommand();
            case SHOW_COMMAND : return new ShowCommand();
            default : System.err.println("Command wasn't found!");
        }
        throw new RuntimeException("Given number doesn't match with any available command!");
    }
}
