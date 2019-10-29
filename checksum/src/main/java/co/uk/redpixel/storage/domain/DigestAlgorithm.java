package co.uk.redpixel.storage.domain;

public enum DigestAlgorithm {
    SHA1("SHA-1"),
    MD5("MD5");

    private final String name;

    DigestAlgorithm(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
