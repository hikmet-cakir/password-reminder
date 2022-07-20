package util;

import enums.CommandEnum;

public class Help {
    private static final String ONE_BLANK = " ";

    private static final String NEW_LINE = "\n";

    public static void printMenu() {
        System.out.println("Exist Commands");
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

    public static void printBanner() {
        System.out.println("  ____                                     _      ____                _           _           \n" +
                " |  _ \\ __ _ ___ _____      _____  _ __ __| |    |  _ \\ ___ _ __ ___ (_)_ __   __| | ___ _ __ \n" +
                " | |_) / _` / __/ __\\ \\ /\\ / / _ \\| '__/ _` |    | |_) / _ \\ '_ ` _ \\| | '_ \\ / _` |/ _ \\ '__|\n" +
                " |  __/ (_| \\__ \\__ \\\\ V  V / (_) | | | (_| |    |  _ <  __/ | | | | | | | | | (_| |  __/ |   \n" +
                " |_|   \\__,_|___/___/ \\_/\\_/ \\___/|_|  \\__,_|    |_| \\_\\___|_| |_| |_|_|_| |_|\\__,_|\\___|_|   \n" +
                "                                                                                              ");
    }
}
