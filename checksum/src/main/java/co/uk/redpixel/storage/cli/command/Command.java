package co.uk.redpixel.storage.cli.command;

import co.uk.redpixel.storage.cli.CommandLineOption;

import java.util.Scanner;

import static java.lang.String.format;

public interface Command {

    void execute();

    static CommandBuilder builder() {
        return new CommandBuilder();
    }

    class CommandBuilder {

        private Scanner scanner;
        private CommandLineOption option;

        private CommandBuilder() {}

        public CommandBuilder of(CommandLineOption option) {
            this.option = option;
            return this;
        }

        public CommandBuilder with(Scanner scanner) {
            this.scanner = scanner;
            return this;
        }

        public Command build() {
            switch (option) {
                case GET:
                    return GetImageCommand.INSTANCE.withScanner(scanner);
                case ADD:
                    return AddImageCommand.INSTANCE.withScanner(scanner);
                case SIZE:
                    return GetSizeCommand.INSTANCE;
                default:
                    throw new IllegalStateException(
                            format("Option '%s' is not supported",
                                    option.name()));
            }
        }
    }
}
