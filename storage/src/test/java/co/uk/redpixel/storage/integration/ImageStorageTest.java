package co.uk.redpixel.storage.integration;

import co.uk.redpixel.storage.domain.Image;
import co.uk.redpixel.storage.util.ClasspathUtils;
import co.uk.redpixel.storage.ImageStore;
import org.junit.*;
import org.testcontainers.containers.GenericContainer;
import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

public class ImageStorageTest {

    private static final String DOCKER_IMAGE_NAME = "redis:4.0.5-alpine";
    private static final int DOCKER_CONTAINER_PORT = 6379;

    private Jedis jedis;

    @Rule
    public GenericContainer redis =
            new GenericContainer(DOCKER_IMAGE_NAME)
                    .withExposedPorts(DOCKER_CONTAINER_PORT);

    @Before
    public void setUp() {
        jedis = new Jedis(redis.getContainerIpAddress(), redis.getMappedPort(DOCKER_CONTAINER_PORT));
    }

    @Test
    public void sameImageStoredNoMoreThanOnce() throws Exception {
        try (ImageStore store = new ImageStore(jedis)) {
            byte[] content1 = ClasspathUtils.loadResource("hotels/hotel2.jpg");
            byte[] content2 = ClasspathUtils.loadResource("hotels/hotel2.jpg");

            Image image1 = Image.of(content1, "jpg");
            Image image2 = Image.of(content2, "jpg");

            store.storeImage("image1", image1);
            store.storeImage("image2", image2);

            assertEquals(1, store.size());
        }
    }

    @Test
    public void storesTwoDifferentImages() throws Exception {
        try (ImageStore store = new ImageStore(jedis)) {
            byte[] content1 = ClasspathUtils.loadResource("hotels/hotel1.jpg");
            byte[] content2 = ClasspathUtils.loadResource("hotels/hotel2.jpg");

            Image image1 = Image.of(content1, "jpg");
            Image image2 = Image.of(content2, "jpg");

            store.storeImage("image1", image1);
            store.storeImage("image2", image2);

            assertEquals(2, store.size());
        }
    }
}
