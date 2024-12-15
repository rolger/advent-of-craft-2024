package gift;

import org.junit.jupiter.api.Test;

import static gift.ChildBuilder.aNaughtyChild;
import static gift.ChildBuilder.aNiceChild;
import static org.assertj.core.api.Assertions.assertThat;

class SantaServiceTests {

    private final SantaService service = new SantaService();

    @Test
    void requestIsApprovedForNiceChildWithFeasibleGift() {
        Child niceChild = aNiceChild().withFeasibleGift().createChild();
        assertThat(service.evaluateRequest(niceChild)).isTrue();
    }

    @Test
    void requestIsDeniedForNaughtyChild() {
        Child naughtyChild = aNaughtyChild().withInfeasibleGift().createChild();
        assertThat(service.evaluateRequest(naughtyChild)).isFalse();
    }

    @Test
    void requestIsDeniedForNiceChildWithInfeasibleGift() {
        Child niceChildWithInfeasibleGift = aNiceChild().withInfeasibleGift().createChild();
        assertThat(service.evaluateRequest(niceChildWithInfeasibleGift)).isFalse();
    }
}