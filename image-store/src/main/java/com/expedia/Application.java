package com.expedia;

import com.expedia.cli.ImageStoreOptions;
import com.expedia.cli.CommandLineRunner;

public class Application {

    public static void main(String[] args) {
        try {
            CommandLineRunner.of(new ImageStoreOptions()).run(args);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
