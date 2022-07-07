package command;

public class CommandFactory {

    public static Command getCommand(Integer number) {
        switch (number) {
            case 0 : return new AddCommand();
            case 1 : return new DeleteCommand();
            case 2 : return new ShowCommand();
            default : System.err.println("Command wasn't found!");
        }
        throw new RuntimeException("Given number doesn't match with any available command!");
    }
}
