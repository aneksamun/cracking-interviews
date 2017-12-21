package com.expedia.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.Optional;

public final class ImageStoreOptions extends Options {

    public ImageStoreOptions() {
        for (ImageStoreOption value : ImageStoreOption.values()) {
            addOption(Option.builder()
                    .longOpt(value.getName())
                    .desc(value.getDescription())
                    .build());
        }
    }

    public static Optional<ImageStoreOption> filter(Option[] options) {
        Option option = options[0];
        for (ImageStoreOption value : ImageStoreOption.values()) {
            if (option.getLongOpt().equals(value.getName())) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
