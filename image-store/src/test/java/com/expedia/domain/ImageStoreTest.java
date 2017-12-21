package com.expedia.domain;

import com.expedia.common.ClasspathUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageStoreTest {

    @Test
    public void testImageStoring() throws Exception {
        try (ImageStore store = new ImageStore()) {
            byte[] image1 = ClasspathUtils.loadResource("hotels/hotel2.jpg");
            byte[] image2 = ClasspathUtils.loadResource("hotels/hotel2.jpg");

            store.storeImage("image1", image1);
            store.storeImage("image2", image2);

            assertEquals(1, store.size());
        }
    }
}