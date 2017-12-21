package com.expedia.cli;

import org.apache.commons.cli.*;

import java.util.List;

import static com.expedia.cli.ImageStoreOption.PRINT_HELP;

public final class CommandLineRunner {

    private final Options options;

    private CommandLineRunner(Options options) {
        this.options = options;
    }

    public static CommandLineRunner of(Options options) {
        return new CommandLineRunner(options);
    }

    public void run(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);

        ImageStoreOption option =
                ImageStoreOptions.filter(commandLine.getOptions())
                        .orElse(PRINT_HELP);

        switch (option) {
            case ADD_IMAGE: break;
            case GET_IMAGE: break;
            case GET_SIZE: break;
            default:
        }
    }
}
