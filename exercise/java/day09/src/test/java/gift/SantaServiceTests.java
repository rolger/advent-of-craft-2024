package gift;

import org.junit.jupiter.api.Test;

import static gift.ChildBuilder.aNaughtyChild;
import static gift.ChildBuilder.aNiceChild;
import static gift.SantaServiceAssertion.assertThat;

class SantaServiceTests {

    private final SantaService service = new SantaService();

    @Test
    void requestIsApprovedForNiceChildWithFeasibleGift() {
        assertThat(service).shouldApprove(aNiceChild().withFeasibleGift());
    }

    @Test
    void requestIsDeniedForNaughtyChild() {
        assertThat(service).shouldDeny(aNaughtyChild().withFeasibleGift());
    }

    @Test
    void requestIsDeniedForNiceChildWithInfeasibleGift() {
        assertThat(service).shouldDeny(aNiceChild().withInfeasibleGift());
    }
}