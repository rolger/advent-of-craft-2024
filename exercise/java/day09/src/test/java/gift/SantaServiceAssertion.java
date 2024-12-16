package gift;

import org.assertj.core.api.AbstractAssert;

public class SantaServiceAssertion extends AbstractAssert<SantaServiceAssertion, SantaService> {
    public SantaServiceAssertion(SantaService santaService) {
        super(santaService, SantaServiceAssertion.class);
    }

    public static SantaServiceAssertion assertThat(SantaService actual) {
        return new SantaServiceAssertion(actual);
    }

    public SantaServiceAssertion shouldDeny(ChildBuilder child) {
        isNotNull();
        if (actual.evaluateRequest(child.createChild())) {
            failWithMessage("Expected SantaService to deny request for child, but it didn't");
        }
        return this;
    }

    public SantaServiceAssertion shouldApprove(ChildBuilder child) {
        isNotNull();
        if (!actual.evaluateRequest(child.createChild())) {
            failWithMessage("Expected SantaService to approve request for child, but it didn't");
        }
        return this;
    }

}
