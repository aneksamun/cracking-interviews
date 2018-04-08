package co.uk.redpixel.storage.common;

import org.junit.Test;

import java.util.Optional;

import static co.uk.redpixel.storage.common.ImageFormat.BMP;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImageFormatTest {

    @Test
    public void noImageFormatResolved() {
        Optional<ImageFormat> option = ImageFormat.find("txt");
        assertThat(option.isPresent(), equalTo(false));
    }

    @Test
    public void resolvesImageFormat() {
        Optional<ImageFormat> format = ImageFormat.find(BMP.getExtension());
        assertThat(format.isPresent(), equalTo(true));
    }
}
