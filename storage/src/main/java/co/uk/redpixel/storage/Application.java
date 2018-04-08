package co.uk.redpixel.storage;

import co.uk.redpixel.storage.cli.CommandLineOption;
import co.uk.redpixel.storage.cli.command.Command;

import java.util.Optional;
import java.util.Scanner;

import static co.uk.redpixel.storage.cli.CommandLineOption.QUIT;

public class Application {

    public static void main(String[] args) {
        System.out.println("Welcome to storage!\n");

        printHelp();

        try (Scanner scanner = new Scanner(System.in)) {
            for (;;) {
                try {
                    System.out.print("\nEnter option: ");
                    Optional<CommandLineOption> optional =
                            CommandLineOption.find(scanner.nextLine());

                    if (!optional.isPresent()) {
                        System.out.println("Invalid option\n");
                        printHelp();
                        System.out.println();
                        continue;
                    }

                    CommandLineOption option = optional.get();

                    if (option == QUIT)
                        break;

                    Command command = Command.builder()
                            .of(option)
                            .with(scanner)
                            .build();

                    command.execute();

                } catch (Exception e) {
                    System.out.println("\nAn error occurred: " + e.getMessage());
                }
            }
        }
    }

    private static void printHelp() {
        System.out.println("1 - add file");
        System.out.println("2 - get file");
        System.out.println("3 - get size");
        System.out.println("q - to quit");
    }
}
