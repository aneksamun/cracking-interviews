package com.wowcher;

import org.apache.commons.cli.*;

public class Application {

    public static void main(String[] args) {
        try {
            CommandLineParser parser = new DefaultParser();
            SpeakingClockOptions options = new SpeakingClockOptions();
            CommandLine commandLine = parser.parse(options, args);

            if (commandLine.getArgs().length == 1) {
                System.out.println(SpeakingClock.speak(TimeParser.parse(args[0])));
                return;
            }

            new HelpFormatter().printHelp("java -jar speaking-clock-1.0-SNAPSHOT.jar [TIME]", options);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    static class SpeakingClockOptions extends Options {

        SpeakingClockOptions() {
            Option help = Option.builder("h")
                    .longOpt("help")
                    .required(false)
                    .desc("shows usage")
                    .build();
            addOption(help);
        }
    }
}
