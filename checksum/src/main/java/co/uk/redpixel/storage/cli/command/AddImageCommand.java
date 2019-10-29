package co.uk.redpixel.storage.cli.command;

import co.uk.redpixel.storage.common.ImageUtils;
import co.uk.redpixel.storage.domain.Image;
import co.uk.redpixel.storage.ImageStore;

import java.io.File;
import java.util.Scanner;

class AddImageCommand implements Command {

    static final AddImageCommand INSTANCE = new AddImageCommand();

    private Scanner scanner;

    private AddImageCommand() {}

    AddImageCommand withScanner(Scanner scanner) {
        this.scanner = scanner;
        return this;
    }

    @Override
    public void execute() {
        try (ImageStore store = new ImageStore()) {
            System.out.print("Enter image ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter image name including path: ");
            File file = new File(scanner.nextLine());
            Image image = ImageUtils.loadImage(file);

            store.storeImage(id, image);
            System.out.println("Image stored successfully...");
        }
    }
}
