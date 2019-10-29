package co.uk.redpixel.storage.domain;

import co.uk.redpixel.storage.exception.ServiceException;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Optional;

import static co.uk.redpixel.storage.domain.DigestAlgorithm.SHA1;
import static co.uk.redpixel.storage.common.Error.HASH_COMPUTE_ERROR;

public final class Digest {

    private final byte[] value;

    private Digest(byte[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        for (byte bit : value) {
            formatter.format("%02x", bit);
        }
        return formatter.toString();
    }

    public static class Builder {
        private final byte[] file;
        private MessageDigest messageDigest;

        private Builder(byte[] file) {
            this.file = file;
        }

        public static Builder of(byte[] file) {
            return new Builder(file);
        }

        public Builder using(DigestAlgorithm algorithm) {
            try {
                this.messageDigest = MessageDigest.getInstance(algorithm.getName());
                return this;
            } catch (Exception e) {
                throw new ServiceException(HASH_COMPUTE_ERROR, e);
            }
        }

        public Digest build() {
            try {
                messageDigest = Optional.ofNullable(messageDigest).orElse(MessageDigest.getInstance(SHA1.getName()));
                byte[] hashValue = messageDigest.digest(file);
                return new Digest(hashValue);
            } catch (Exception e) {
                throw new ServiceException(HASH_COMPUTE_ERROR, e);
            }
        }
    }
}
