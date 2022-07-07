package enums;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum CommandEnum {
    ADD_COMMAND(1),
    DELETE_COMMAND(2),
    SHOW_COMMAND(3);

    private Integer id;

    CommandEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static CommandEnum fromId(Integer id) {
        OptionalCommandEnum command = stream(CommandEnum.values())
                .filter(commandEnum - commandEnum.getId().equals(id))
                .findAny();
        return command.orElse(null);
    }
}
