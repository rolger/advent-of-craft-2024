package gift;

import org.junit.jupiter.api.Test;

import static gift.ChildBuilder.aNaughtyChild;
import static gift.ChildBuilder.aNiceChild;
import static org.assertj.core.api.Assertions.assertThat;

class SantaServiceTests {

    private final SantaService service = new SantaService();

    @Test
    void requestIsApprovedForNiceChildWithFeasibleGift() {
        assertThat(service.evaluateRequest(
                aNiceChild().withFeasibleGift().createChild())
        ).isTrue();
    }

    @Test
    void requestIsDeniedForNaughtyChild() {
        assertThat(service.evaluateRequest(
                aNaughtyChild().withInfeasibleGift().createChild())
        ).isFalse();
    }

    @Test
    void requestIsDeniedForNiceChildWithInfeasibleGift() {
        assertThat(service.evaluateRequest(
                aNiceChild().withInfeasibleGift().createChild())
        ).isFalse();
    }
}