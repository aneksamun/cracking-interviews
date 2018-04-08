package co.uk.redpixel.storage.cli.command;

import co.uk.redpixel.storage.common.ImageUtils;
import co.uk.redpixel.storage.domain.Image;
import co.uk.redpixel.storage.ImageStore;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

class GetImageCommand implements Command {

    static final GetImageCommand INSTANCE = new GetImageCommand();

    private Scanner scanner;

    private GetImageCommand() {}

    GetImageCommand withScanner(Scanner scanner) {
        this.scanner = scanner;
        return this;
    }

    @Override
    public void execute() {
        try (ImageStore store = new ImageStore()) {
            System.out.print("Enter image ID: ");
            String id = scanner.nextLine();

            Optional<Image> image = store.fetchImage(id);

            if (!image.isPresent()) {
                System.out.println("Image not found.");
                return;
            }

            while (true) {
                System.out.print("Enter path to store image: ");
                Path path = Paths.get(scanner.nextLine());

                if (!Files.exists(path)) {
                    System.out.println("Path does not exists.");
                } else {
                    ImageUtils.saveImage(id, image.get(), path);
                    System.out.println("Image retrieved successfully...");
                    break;
                }
            }
        }
    }
}
