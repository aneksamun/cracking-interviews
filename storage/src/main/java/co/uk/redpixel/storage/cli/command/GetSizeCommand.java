package co.uk.redpixel.storage.cli.command;

import co.uk.redpixel.storage.ImageStore;

public class GetSizeCommand implements Command {

    static final GetSizeCommand INSTANCE = new GetSizeCommand();

    private GetSizeCommand() {}

    @Override
    public void execute() {
        try (ImageStore store = new ImageStore()) {
            System.out.println("Images count in store is " + store.size());
        }
    }
}
