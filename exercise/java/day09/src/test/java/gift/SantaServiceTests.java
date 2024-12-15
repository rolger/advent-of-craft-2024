package gift;

import org.junit.jupiter.api.Test;

import static gift.ChildBuilder.aNaughtyChild;
import static gift.ChildBuilder.aNiceChild;
import static org.assertj.core.api.Assertions.assertThat;

class SantaServiceTests {

    private final SantaService service = new SantaService();

    @Test
    void requestIsApprovedForNiceChildWithFeasibleGift() {
        Child niceChild = aNiceChild().setFirstName("Alice").setLastName("Thomas").setAge(9).setGiftRequest(new GiftRequest("Bicycle", true, Priority.NICE_TO_HAVE)).createChild();
        assertThat(service.evaluateRequest(niceChild)).isTrue();
    }

    @Test
    void requestIsDeniedForNaughtyChild() {
        Child naughtyChild = aNaughtyChild().setFirstName("Noa").setLastName("Thierry").setAge(6).setGiftRequest(new GiftRequest("SomeToy", true, Priority.DREAM)).createChild();
        assertThat(service.evaluateRequest(naughtyChild)).isFalse();
    }

    @Test
    void requestIsDeniedForNiceChildWithInfeasibleGift() {
        Child niceChildWithInfeasibleGift = aNiceChild().setFirstName("Charlie").setLastName("Joie").setAge(3).setBehavior(Behavior.NICE).setGiftRequest(new GiftRequest("AnotherToy", false, Priority.DREAM)).createChild();
        assertThat(service.evaluateRequest(niceChildWithInfeasibleGift)).isFalse();
    }
}