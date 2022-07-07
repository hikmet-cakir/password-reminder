package command;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Show Command");
    }
}
