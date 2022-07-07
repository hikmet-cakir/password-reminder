package enums;

import java.util.Optional;

import static java.util.Arrays.stream;

public enum CommandEnum {
    ADD_COMMAND(0),
    DELETE_COMMAND(1),
    SHOW_COMMAND(2);

    private Integer id;

    CommandEnum(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static CommandEnum fromId(Integer id) {
        Optional<CommandEnum> command = stream(CommandEnum.values())
                .filter(commandEnum -> commandEnum.getId().equals(id))
                .findAny();
        return command.orElse(null);
    }
}
