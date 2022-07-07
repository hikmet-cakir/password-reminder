package util;

public class Help {

    private static final Integer ADD_COMMAND_NUMBER = 0;

    private static final Integer DELETE_COMMAND_NUMBER = 1;

    private static final Integer SHOW_COMMAND_NUMBER = 2;

    private static final String ONE_BLANK = " ";

    private static final String NEW_LINE = "\n";

    public static void printMenu() {
        String menuMessage = new StringBuilder()
                .append(ADD_COMMAND_NUMBER)
                .append(ONE_BLANK)
                .append("is used for Add Command")
                .append(NEW_LINE)
                .append(DELETE_COMMAND_NUMBER)
                .append(ONE_BLANK)
                .append("is used for Delete Command")
                .append(NEW_LINE)
                .append(SHOW_COMMAND_NUMBER)
                .append(ONE_BLANK)
                .append("is used for Show Command")
                .toString();
        System.out.println(menuMessage);
    }
}
