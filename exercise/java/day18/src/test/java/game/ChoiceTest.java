package game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ChoiceTest {

    @ParameterizedTest
    @CsvSource({
            "SCISSORS,rock crushes scissors",
            "LIZARD,rock crushes lizard"
    })
    void rockShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.ROCK.beatsWithMessage(other)).hasValue(expectedMessage);
    }

}