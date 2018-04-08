package co.uk.redpixel.storage.cli;

import java.util.Optional;

public enum CommandLineOption {
    ADD("1"),
    GET("2"),
    SIZE("3"),
    QUIT("q");

    private final String value;

    CommandLineOption(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    public static Optional<CommandLineOption> find(String option) {
        for (CommandLineOption current : values()) {
            if (current.getValue().equalsIgnoreCase(option)) {
                return Optional.of(current);
            }
        }
        return Optional.empty();
    }
}
