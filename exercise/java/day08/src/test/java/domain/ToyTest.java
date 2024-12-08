package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ToyTest {

    @Test
    void assignToElf_should_change_state_to_production_after_assignment() {
        Toy toy = new Toy("Train", Toy.State.UNASSIGNED);

        toy.assignToElf();

        assertThat(toy.getState()).isEqualTo(Toy.State.IN_PRODUCTION);
    }

    @Test
    void assignToElf_should_not_change_state_after_reassignment() {
        Toy toy = new Toy("Train", Toy.State.IN_PRODUCTION);

        toy.assignToElf();

        assertThat(toy.getState()).isEqualTo(Toy.State.IN_PRODUCTION);
    }

    @Test
    void assignToElf_should_tell_if_changed() {
        Toy toy = new Toy("Train", Toy.State.UNASSIGNED);

        var toBeSaved = toy.assignToElf();

        assertThat(toBeSaved).isTrue();
    }
}