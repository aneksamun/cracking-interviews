package com.expedia.cli.handler;

import com.expedia.domain.ImageStore;

public final class GetSizeCommandHandler {

    public void execute() {
        try (ImageStore store = new ImageStore()) {
            System.out.println("Image count in store is " + store.size());
        }
    }
}
