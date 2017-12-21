package com.expedia.cli;

public enum ImageStoreOption {
    ADD_IMAGE("add", "Stores image by given ID and path"),
    GET_IMAGE("get", "Retrieves image by ID"),
    GET_SIZE("size", "Gets count of the stored images"),
    PRINT_HELP("help", "Prints help");

    private final String name;
    private final String description;

    ImageStoreOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
