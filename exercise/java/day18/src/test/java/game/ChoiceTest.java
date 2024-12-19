package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ChoiceTest {

    @Test
    void rockShouldBeatScissorWithMessage() {
        Choice.ROCK.beatsWithMessage(Choice.SCISSORS).ifPresentOrElse(
                message -> assertEquals("rock crushes scissors", message),
                () -> fail("rock should beat scissors")
        );
    }
}