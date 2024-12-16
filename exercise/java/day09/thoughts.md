# Thoughts of day 9

## first impressions
I'm not sure if this is a good idea. Is the data complicated enough to use a builder? I'm going to try it.  

## steps
I remember that IntelliJ is going to create a builder for me. Insert ... (Alt-Insert) didn't work, so I had to search for the right command. It's a refactoring command, I need to select the constructor, and it's going to create a builder for all parameters. Cool.

Now I refactor the code step-by-step. This time I took care to commit after each refactoring step. Finally, I agree that the tests are more readable now.

```java
@Test
void requestIsApprovedForNiceChildWithFeasibleGift() {
    assertThat(service.evaluateRequest(
            aNiceChild().withFeasibleGift().createChild())
    ).isTrue();
}
```

Should I keep the other setters in the Builder? I decided to remove them, I don't need them currently.

After reading the comments in Discord, I still unhappy with the `isTrue()` call, it's not clear what it means. I would like to change it to `shouldApprove()`. I checked out the AssertJ documentation and found that I can create a custom assertion. I'm going to try it. 

```java
@Test
void requestIsDeniedForNiceChildWithInfeasibleGift() {
    assertThat(service).shouldDeny(aNiceChild().withInfeasibleGift().createChild());
}
```
 Wow, that's cool. The test is even more readable now.

## alternatives


Other alternatives:
* a separate builder for the class GiftRequest
* build() or createChild() method in the builder
* I'd like to name it like `assertThat(service).shouldApprove(aFeasibleGift().fromANiceChild().createChild())`. Then I need a `GiftRequestBuilder` instead of a `ChildBuilder`, but it would return a Child??? 
* Can I remove the build call? `assertThat(service).shouldApprove(aFeasibleGift().fromANiceChild().build())`









