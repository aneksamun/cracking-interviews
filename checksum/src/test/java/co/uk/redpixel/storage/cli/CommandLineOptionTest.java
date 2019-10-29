package co.uk.redpixel.storage.cli;

import org.junit.Test;

import java.util.Optional;

import static co.uk.redpixel.storage.cli.CommandLineOption.QUIT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CommandLineOptionTest {

    @Test
    public void noCommandLineOptionDetected() {
        Optional<CommandLineOption> option = CommandLineOption.find("?");
        assertThat(option.isPresent(), equalTo(false));
    }

    @Test
    public void detectsCommandLineOption() {
        Optional<CommandLineOption> option = CommandLineOption.find(QUIT.getValue());
        assertThat(option.isPresent(), equalTo(true));
    }
}
