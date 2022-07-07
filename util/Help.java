package util;

import enums.CommandEnum;

public class Help {
    private static final String ONE_BLANK = " ";

    private static final String NEW_LINE = "\n";

    public static void printMenu() {
        String menuMessage = new StringBuilder()
                .append(CommandEnum.ADD_COMMAND.getId())
                .append(ONE_BLANK)
                .append("is used for Add Command")
                .append(NEW_LINE)
                .append(CommandEnum.DELETE_COMMAND.getId())
                .append(ONE_BLANK)
                .append("is used for Delete Command")
                .append(NEW_LINE)
                .append(CommandEnum.SHOW_COMMAND.getId())
                .append(ONE_BLANK)
                .append("is used for Show Command")
                .toString();
        System.out.println(menuMessage);
    }
}
