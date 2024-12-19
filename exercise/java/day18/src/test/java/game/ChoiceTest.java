package game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

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
            "SPOCK,paper disproves spock"
    })
    void paperShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.PAPER.beatsWithMessage(other)).hasValue(expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"LIZARD", "SCISSORS"})
    void paperShouldNotBeat(Choice other) {
        assertThat(Choice.PAPER.beatsWithMessage(other)).isNotPresent();
    }


    @ParameterizedTest
    @CsvSource({
            "PAPER,scissors cuts paper",
            "LIZARD,scissors decapitates lizard"
    })
    void scissorsShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.SCISSORS.beatsWithMessage(other)).hasValue(expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"ROCK", "SPOCK"})
    void scissorsShouldNotBeat(Choice other) {
        assertThat(Choice.SCISSORS.beatsWithMessage(other)).isNotPresent();
    }

    @ParameterizedTest
    @CsvSource({
            "PAPER,lizard eats paper",
            "SPOCK,lizard poisons spock"
    })
    void lizardShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.LIZARD.beatsWithMessage(other)).hasValue(expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"ROCK", "SCISSORS"})
    void lizardShouldNotBeat(Choice other) {
        assertThat(Choice.LIZARD.beatsWithMessage(other)).isNotPresent();
    }

    @ParameterizedTest
    @CsvSource({
            "SCISSORS,spock smashes scissors",
            "ROCK,spock vaporizes rock"
    })
    void spockShouldBeatWithMessage(Choice other, String expectedMessage) {
        assertThat(Choice.SPOCK.beatsWithMessage(other)).hasValue(expectedMessage);
    }

    @ParameterizedTest
    @EnumSource(value = Choice.class, names = {"LIZARD", "PAPER"})
    void spockShouldNotBeat(Choice other) {
        assertThat(Choice.SPOCK.beatsWithMessage(other)).isNotPresent();
    }
}