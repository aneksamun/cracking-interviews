package com.expedia.domain;

import redis.clients.jedis.Jedis;

import java.io.Closeable;
import java.util.Base64;

public class ImageStore implements Closeable {

    private static final String IMAGE_SET_NAME = "images";

    private final Jedis jedis;

    public ImageStore() {
        this(new Jedis());
    }

    protected ImageStore(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * Inserts an image in the store
     *
     * @param id    -- The identifier of the image
     * @param image -- The content of the image
     */
    public void storeImage(String id, byte[] image) {
        Digest digest = Digest.Builder.of(image).build();

        String checksum = digest.toString();
        String encodedImage = Base64.getEncoder().encodeToString(image);

        jedis.sadd(IMAGE_SET_NAME, checksum, encodedImage);
        jedis.set(id, checksum);
    }

    /**
     * Retrieves an image from the store
     *
     * @param id -- The identifier of the image to be retrieved
     * @return the image content
     */
    public byte[] fetchImage(String id) {
        String encodedImage = jedis.get(id);
        if (encodedImage == null) {
            return null;
        }
        return Base64.getDecoder().decode(encodedImage);
    }

    /**
     * The size of the store
     *
     * @return the actual store size
     */
    public int size() {
        final int fieldsCountPerKey = 2;
        Long total = jedis.scard(IMAGE_SET_NAME);
        return (int) (total / fieldsCountPerKey);
    }

    @Override
    public void close() {
        jedis.close();
    }
}
