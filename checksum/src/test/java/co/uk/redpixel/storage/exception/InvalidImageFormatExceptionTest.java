package co.uk.redpixel.storage.exception;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class InvalidImageFormatExceptionTest {

    @Test
    public void testMessageBuilding() {
        String expectedMessage = "File should have jpg, gif, png, bmp or jpeg extension.";
        Exception exception = new InvalidImageFormatException();
        assertThat(exception.getMessage(), equalTo(expectedMessage));
    }
}
