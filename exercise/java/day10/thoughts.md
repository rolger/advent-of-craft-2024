# Thoughts of day 10

## first impressions

**still under construction**


## refactoring steps

With the tests in place I was able to refactor th code step by step. The tests were running after each step.

* I started with Yoan's suggestion of introducing a constant for the elf.
* I changed the if statement to a switch expression so that both strategies look similar.
* This triggered the idea of extracting constants for the up and down instruction character.
* I'm still **unhappy with the default case** in the switch expression, but I don't have detailed requirements yet. So I just added a comment to indicate that this is a potential problem.
* I changed the parameter of the strategy method to an int instead of a char since I wanted to get rid of the cast in the map operation (still not sure about that).
* I renamed the method returning the strategy to `createFloorStrategy` to make it clearer that it's a factory method, extracted variables for the standard case and case when an elf is added to the instructions and replaced the if statement.
* I extracted the functions of the two strategies to constants. Now I'm happy with the factory method.
* Finally, I introduced a functional interface `FloorStrategy` to make the code more readable and to get rid of the apply call in the map operation.

Then I refactored the tests.
* I created tests cases for each combination of simple instructions and expected floors i.e. single up, single down, multiple ups for each strategy.
* I deleted the old tests with its input files.





