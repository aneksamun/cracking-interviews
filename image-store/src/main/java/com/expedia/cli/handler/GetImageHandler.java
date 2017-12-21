package com.expedia.cli.handler;

import com.expedia.domain.ImageStore;

import java.util.List;

public final class GetImageHandler {

    private final String id;
    private final String path;

    public GetImageHandler(List<String> args) {
        this.id = args.get(0);
        this.path = args.get(1);
    }

    @Override
    public void execute() {
        try (ImageStore store = new ImageStore()) {

        }
    }
}
