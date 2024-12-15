package gift;

import org.junit.jupiter.api.Test;

import static gift.ChildBuilder.aNaughtyChild;
import static gift.ChildBuilder.aNiceChild;
import static gift.SantaServiceAssertion.assertThat;

class SantaServiceTests {

    private final SantaService service = new SantaService();

    @Test
    void requestIsApprovedForNiceChildWithFeasibleGift() {
        assertThat(service).shouldApprove(aNiceChild().withFeasibleGift().createChild());
    }

    @Test
    void requestIsDeniedForNaughtyChild() {
        assertThat(service).shouldDeny(aNaughtyChild().withFeasibleGift().createChild());
    }

    @Test
    void requestIsDeniedForNiceChildWithInfeasibleGift() {
        assertThat(service).shouldDeny(aNiceChild().withInfeasibleGift().createChild());
    }
}