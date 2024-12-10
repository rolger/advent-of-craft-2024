import org.junit.jupiter.api.Test;

import static delivery.Building.whichFloor;
import static org.assertj.core.api.Assertions.assertThat;

class DeliveryTest {
    @Test
    public void standardFloorWithAnUpInstructionIsLevelPlusOne() {
        var instructions = "(";

        assertThat(whichFloor(instructions)).isEqualTo(1);
    }

    @Test
    public void standardFloorWithADownInstructionIsLevelMinusOne() {
        var instructions = ")";

        assertThat(whichFloor(instructions)).isEqualTo(-1);
    }

    @Test
    public void standardFloorWithMultipleInstructionsIsSum() {
        var instructions = "(()))";

        assertThat(whichFloor(instructions)).isEqualTo(-1);
    }

    @Test
    public void secretFloorWithAnUpInstructionIsLevelMinusTwo() {
        var instructions = "(🧝";

        assertThat(whichFloor(instructions)).isEqualTo(-2);
    }

    @Test
    public void secretFloorWithADownInstructionIsLevelPlusThree() {
        var instructions = ")🧝";

        assertThat(whichFloor(instructions)).isEqualTo(3);
    }

    @Test
    public void secretFloorWithMultipleInstructionsIsSum() {
        var instructions = "(()🧝)";

        assertThat(whichFloor(instructions)).isEqualTo(2);
    }

}