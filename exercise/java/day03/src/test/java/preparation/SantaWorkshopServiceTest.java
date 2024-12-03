package preparation;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.lifecycle.BeforeProperty;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SantaWorkshopServiceTest {
    private static final String RECOMMENDED_AGE = "recommendedAge";
    private SantaWorkshopService service;

    @BeforeProperty
    void setUp() {
        service = new SantaWorkshopService();
    }

    @Property
    void prepareGiftWithValidToyShouldInstantiateIt(@ForAll @DoubleRange(min = 0.0, max = 5.0, maxIncluded = false) double w) {
        var giftName = "Bitzee";
        double weight = w;
        var color = "Purple";
        var material = "Plastic";

        var gift = service.prepareGift(giftName, weight, color, material);

        assertThat(gift).isNotNull();
    }

    @Provide
    Arbitrary<String> stringsExceptRecommendedAge() {
        return Arbitraries.strings().filter(aString -> aString != RECOMMENDED_AGE);
    }

    @Property
    void whenAttributeIsNotRecommendedAgeThenRecommendedAgeOnGiftShouldBeZero(@ForAll("stringsExceptRecommendedAge") String key, @ForAll String value) {
        var giftName = "Furby";
        double weight = 1;
        var color = "Multi";
        var material = "Cotton";

        var gift = service.prepareGift(giftName, weight, color, material);
        gift.addAttribute(key, value);

        assertThat(gift.getRecommendedAge()).isZero();
    }

    @Property
    void retrieveRecommendedAgeOnGift(@ForAll Integer age) {
        var giftName = "Furby";
        double weight = 1;
        var color = "Multi";
        var material = "Cotton";

        var gift = service.prepareGift(giftName, weight, color, material);
        gift.addAttribute(RECOMMENDED_AGE, String.valueOf(age));

        assertThat(gift.getRecommendedAge()).isEqualTo(age);
    }

    @Property
    void failsForATooHeavyGift(@ForAll @DoubleRange(min = 5.0, minIncluded = false) double w) {
        var giftName = "Dog-E";
        double weight = w;
        var color = "White";
        var material = "Metal";

        assertThatThrownBy(() -> service.prepareGift(giftName, weight, color, material))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gift is too heavy for Santa's sleigh");
    }

}
