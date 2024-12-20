import static org.assertj.core.api.Assertions.*;
import static travel.SantaTravelCalculator.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTests {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3",
            "5, 31",
            "10, 1023",
            "20, 1048575",
            "30, 1073741823",
            "32, 4294967295",
            "50, 1125899906842623"
    })
    void shouldCalculateTheDistanceFor(int numberOfReindeers, long expectedDistance) {
        assertThat(calculateTotalDistance(numberOfReindeers)).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3",
            "5, 31",
            "10, 1023",
            "20, 1048575",
            "30, 1073741823",
            "32, 4294967295",
            "50, 1125899906842623"
    })
    void shouldCalculateTheDistanceRecursivelyFor(int numberOfReindeers, long expectedDistance) {
        assertThat(calculateTotalDistanceRecursively(numberOfReindeers)).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 3",
            "5, 31",
            "10, 1023",
            "20, 1048575",
            "30, 1073741823",
            "32, 4294967295",
            "50, 1125899906842623"
    })
    void shouldCalculateTheDistanceBitOPsFor(int numberOfReindeers, long expectedDistance) {
        assertThat(calculateTotalDistanceWithBitOps(numberOfReindeers)).isEqualTo(expectedDistance);
    }

}
