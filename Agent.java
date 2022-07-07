import command.Command;

public class Agent {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void doOperation() {
        command.execute();
    }
}
