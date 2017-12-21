package com.expedia.cli.handler;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public final class PrintHelpCommandHandler {

    private final Options options;

    public PrintHelpCommandHandler(Options options) {
        this.options = options;
    }

    @Override
    public void execute() {
        new HelpFormatter().printHelp("image-store [OPTION] [ARGUMENTS]", options);
    }
}
