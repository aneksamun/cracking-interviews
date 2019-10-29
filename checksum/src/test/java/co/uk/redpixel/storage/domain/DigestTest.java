package co.uk.redpixel.storage.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static co.uk.redpixel.storage.util.ClasspathUtils.loadResource;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DigestTest {

    private final String input;
    private final String expectedChecksum;

    public DigestTest(String input, String expectedChecksum) {
        this.input = input;
        this.expectedChecksum = expectedChecksum;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][] {
                { "hotels/hotel1.jpg", "5c0616af12345d6a7aa744c766c29223baab4d28" },
                { "hotels/hotel2.jpg", "446b332b7783edbc9036fd4356419e9e1dc09ce7" }
        });
    }

    @Test
    public void testHashComputation() throws Exception {
        byte[] image = loadResource(input);
        Digest digest = Digest.Builder
                .of(image)
                .using(DigestAlgorithm.SHA1)
                .build();

        assertEquals(expectedChecksum, digest.toString());
    }
}
