# Thoughts on day 3 exercise

## First thoughts
My first idea was Property-Based Testing. I remember when I tried it for my first time, it was a workshop either by Emiley Bache or Nat Pryce at XP2011. I didn't understand the usage and concept at the beginning. I remembered that with Property-Based Testing you implement a data-provider for your tests with specific constrains matching to testcases.     

Then I read the tests, the code and checked the coverage of the existing tests. I thought about using random with seeds, could be sufficient. But I liked the idea of using a framework, and to learn to apply a new framework.  

So in parallel I started to read some articles about Property-Based Testing in Java. I found Baeldung and some German articles. All examples were based on jqwik (https://jqwik.net/). I read the documentation and started to implement the first test.  

## Implementation
The 1st line of the tested method 'prepareGift' is a condition on the variable 'weight'. Furthermore, 'weight' is a double, which is interesting from the point of edge cases. 

I found the testcase 'prepareGiftWithValidToyShouldInstantiateIt' and decided to fuzzy the values of weight in the range form 0.0 to 5.0. It took me some minutes to find the right annotations to restrict the range. The solution with jqwik looks quite simple and clean. I really like the parameterized 'maxIncluded'! 

```java
@Property
void prepareGiftWithValidToyShouldInstantiateIt(@ForAll @DoubleRange(min = 0.0, max = 5.0, maxIncluded = false) double weight) { }
```

At the beginning my tests failed because @BeforeEach was not executed. I found the solution in the documentation of jqwik. I had to use @BeforeProperty. 

Well, then I looked out for the 2nd test. I found 'prepareGiftWithInvalidToyShouldThrowException' and applied the same approach with a different range.  

```java
@Property
void failsForATooHeavyGift(@ForAll @DoubleRange(min = 5.0, minIncluded = false) double weight) { }
```

Next, I wanted to fuzz the values of the key and value of the gift attributes. I thought that it is possible to add any key-value pair to the gift. Wrong, only the key "recommendedAge" is useful. I implemented a new test for invalid keys, since they have to return the value of 0. Surprisingly, this was not display correctly by the code coverage view.    

```java  
@Provide
Arbitrary<String> stringsExceptRecommendedAge() {
    return Arbitraries.strings().filter(aString -> !aString.equals(RECOMMENDED_AGE));
}

@Property
void whenAttributeIsNotRecommendedAgeThenRecommendedAgeOnGiftShouldBeZero(@ForAll("stringsExceptRecommendedAge") String key, @ForAll String value) { }
```

I wanted to explicitly exclude the key "recommendedAge" from the test. I found the solution in the documentation of jqwik. I had to use @Provide and using a filter. Smart!

Finally, there was a test for testing the recommended age. I decided to fuzz the values of the recommended age.

```java
@Property
void retrieveRecommendedAgeOnGift(@ForAll Integer age) { }
```

# Result
I'm surprised by the result of my new tests. Each test is executed 1000 times. The report tells me further that the edge cases are tried in each run.

```
"C:\Program Files\OpenJDK\jdk-21.0.1\bin\java.exe" -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2024.2.2\lib\idea_rt.jar=50922:C:\Program Files\JetBrains\IntelliJ IDEA 2024.2.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\rolandgerm\.m2\repository\org\junit\platform\junit-platform-launcher\1.10.3\junit-platform-launcher-1.10.3.jar;C:\Users\rolandgerm\.m2\repository\org\junit\platform\junit-platform-engine\1.10.3\junit-platform-engine-1.10.3.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.2.2\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.2.2\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA 2024.2.2\plugins\junit\lib\junit-rt.jar;C:\Users\rolandgerm\projects\community\advent-of-craft-2024\exercise\java\day03\target\test-classes;C:\Users\rolandgerm\projects\community\advent-of-craft-2024\exercise\java\day03\target\classes;C:\Users\rolandgerm\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.10.3\junit-jupiter-api-5.10.3.jar;C:\Users\rolandgerm\.m2\repository\org\opentest4j\opentest4j\1.3.0\opentest4j-1.3.0.jar;C:\Users\rolandgerm\.m2\repository\org\junit\platform\junit-platform-commons\1.10.3\junit-platform-commons-1.10.3.jar;C:\Users\rolandgerm\.m2\repository\org\apiguardian\apiguardian-api\1.1.2\apiguardian-api-1.1.2.jar;C:\Users\rolandgerm\.m2\repository\org\junit\jupiter\junit-jupiter-params\5.10.3\junit-jupiter-params-5.10.3.jar;C:\Users\rolandgerm\.m2\repository\org\assertj\assertj-core\3.25.3\assertj-core-3.25.3.jar;C:\Users\rolandgerm\.m2\repository\net\bytebuddy\byte-buddy\1.14.11\byte-buddy-1.14.11.jar;C:\Users\rolandgerm\.m2\repository\net\jqwik\jqwik\1.7.4\jqwik-1.7.4.jar;C:\Users\rolandgerm\.m2\repository\net\jqwik\jqwik-api\1.7.4\jqwik-api-1.7.4.jar;C:\Users\rolandgerm\.m2\repository\net\jqwik\jqwik-web\1.7.4\jqwik-web-1.7.4.jar;C:\Users\rolandgerm\.m2\repository\net\jqwik\jqwik-time\1.7.4\jqwik-time-1.7.4.jar;C:\Users\rolandgerm\.m2\repository\net\jqwik\jqwik-engine\1.7.4\jqwik-engine-1.7.4.jar;C:\Users\rolandgerm\.m2\repository\org\junit\platform\junit-platform-engine\1.9.3\junit-platform-engine-1.9.3.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 preparation.SantaWorkshopServiceTest
timestamp = 2024-12-03T20:07:29.485513900, SantaWorkshopServiceTest:failsForATooHeavyGift =
|-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 2          | # of all combined edge cases
edge-cases#tried = 2          | # of edge cases tried in current run
seed = 3294562663104029456    | random seed to reproduce generated values


timestamp = 2024-12-03T20:07:29.715227400, SantaWorkshopServiceTest:whenAttributeIsNotRecommendedAgeThenRecommendedAgeOnGiftShouldBeZero =
|-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 9          | # of all combined edge cases
edge-cases#tried = 9          | # of edge cases tried in current run
seed = 8961750561513933743    | random seed to reproduce generated values


timestamp = 2024-12-03T20:07:29.758191400, SantaWorkshopServiceTest:prepareGiftWithValidToyShouldInstantiateIt =
|-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 5          | # of all combined edge cases
edge-cases#tried = 5          | # of edge cases tried in current run
seed = 6235295599340417198    | random seed to reproduce generated values


timestamp = 2024-12-03T20:07:29.809734100, SantaWorkshopServiceTest:retrieveRecommendedAgeOnGift =
|-----------------------jqwik-----------------------
tries = 1000                  | # of calls to property
checks = 1000                 | # of not rejected calls
generation = RANDOMIZED       | parameters are randomly generated
after-failure = SAMPLE_FIRST  | try previously failed sample, then previous seed
when-fixed-seed = ALLOW       | fixing the random seed is allowed
edge-cases#mode = MIXIN       | edge cases are mixed in
edge-cases#total = 9          | # of all combined edge cases
edge-cases#tried = 9          | # of edge cases tried in current run
seed = -8399792028715000683   | random seed to reproduce generated values
```

## Final thoughts
After writing my thoughts down, I came up with a refactoring idea. Since I only can retrieve the attribute "recommendedAge" I could use a member variable instead of a map. This would simplify the code and the tests.

```java
public class Gift {

    private int recommendedAge;

    public int getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }
}
```
