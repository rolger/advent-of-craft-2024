package game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

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

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"PAPER", "SPOCK"})
    void rockShouldNotBeat(Choice other) {
        assertThat(Choice.ROCK.beatsWithMessage(other)).isNotPresent();
    }

    @ParameterizedTest
    @CsvSource({
            "ROCK,paper covers rock",
            "SPOCK,paper disproves Spock"
    })
    void paperShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.PAPER.beatsWithMessage(other)).hasValue(expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"LIZARD", "SCISSORS"})
    void paperShouldNotBeat(Choice other) {
        assertThat(Choice.PAPER.beatsWithMessage(other)).isNotPresent();
    }

}