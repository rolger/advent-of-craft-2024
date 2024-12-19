package game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ChoiceTest {

    @ParameterizedTest
    @CsvSource({
            "SCISSORS,rock crushes scissors",
            "LIZARD,rock crushes lizard"
    })
    void rockShouldBeatScissorWithMessage(Choice other, String expectedMessage) {
        Choice.ROCK.beatsWithMessage(other).ifPresentOrElse(
                message -> assertEquals(expectedMessage, message),
                () -> fail("ROCK should beat " + other)
        );
    }

}