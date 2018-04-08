package co.uk.redpixel.storage;

import co.uk.redpixel.storage.domain.Digest;
import co.uk.redpixel.storage.domain.Image;
import co.uk.redpixel.storage.exception.ServiceException;

import co.uk.redpixel.transport.Images;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import redis.clients.jedis.Jedis;

import java.io.Closeable;
import java.util.Base64;
import java.util.Optional;

public class ImageStore implements Closeable {

    private static final String CHECKSUM_KEY_PREFIX = "chk-";

    private final Jedis jedis;

    public ImageStore() {
        this(new Jedis());
    }

    public ImageStore(Jedis jedis) {
        this.jedis = jedis;
    }

    /**
     * Inserts an image in the store
     *
     * @param id    -- The identifier of the image
     * @param image -- The content of the image
     */
    public void storeImage(String id, Image image) {

        Images.Image proto = Images.Image.newBuilder()
                .setExtension(image.getExtension())
                .setContent(ByteString.copyFrom(image.getContent()))
                .build();

        String encodedImage = Base64.getEncoder().encodeToString(proto.toByteArray());

        Digest digest = Digest.Builder.of(image.getContent()).build();
        String checksum = digest.toString();
        String checksumKey = CHECKSUM_KEY_PREFIX + checksum;

        jedis.sadd(checksumKey, encodedImage);
        jedis.set(id, checksumKey);
    }

    /**
     * Retrieves an image from the store
     *
     * @param id -- The identifier of the image to be retrieved
     * @return the image content
     */
    public Optional<Image> fetchImage(String id) {
        Optional<String> checksumKey = Optional.ofNullable(jedis.get(id));
        if (checksumKey.isPresent()) {
            Optional<String> encodedImage = jedis.smembers(checksumKey.get()).stream().findFirst();

            if (encodedImage.isPresent()) {
                try {
                    byte[] content = Base64.getDecoder().decode(encodedImage.get());
                    Images.Image proto = Images.Image.parseFrom(content);
                    return Optional.of(Image.of(proto.getContent().toByteArray(), proto.getExtension()));

                } catch (InvalidProtocolBufferException exception) {
                    throw new ServiceException(exception.getMessage());
                }
            }
        }

        return Optional.empty();
    }

    /**
     * The size of the store
     *
     * @return the actual store size
     */
    public int size() {
        return jedis.keys(CHECKSUM_KEY_PREFIX + "*").size();
    }

    @Override
    public void close() {
        jedis.close();
    }
}
