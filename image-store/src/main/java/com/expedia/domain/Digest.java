package com.expedia.domain;

import com.expedia.common.ServiceException;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Optional;

import static com.expedia.domain.DigestAlgorithm.SHA1;
import static com.expedia.common.Error.HASH_COMPUTE_ERROR;

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
        private final byte[] image;
        private MessageDigest messageDigest;

        private Builder(byte[] image) {
            this.image = image;
        }

        public static Builder of(byte[] image) {
            return new Builder(image);
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
                byte[] hashValue = messageDigest.digest(image);
                return new Digest(hashValue);
            } catch (Exception e) {
                throw new ServiceException(HASH_COMPUTE_ERROR, e);
            }
        }
    }
}
