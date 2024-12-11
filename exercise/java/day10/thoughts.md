# Thoughts of day 10

## first impressions

My first step after creating a new module in my IntelliJ project was running the tests and understanding the tests - especially the logic in the tests and its data. I just thought there is to much input in the failing test, this won't help me to understand what's going on. I checked out the 1st test, which instructions where simpler. I run the tests with coverage, and checked the code afterwards. The code looked complicated - I would call it too much conditional complexity and I identified some obscure dead code. I was wondering about the two for loops, and the confusing names of variables. I was not able to understand what's going on here, that became clear to me. I won't be able to understand the complete business logic be reading the code. Some hints helped me though - the name of the class and the method. I resisted t refactor the code, since my tests were red and the exercise was about fixing a bug. I thougt about "Preparatory Refactoring" (https://martinfowler.com/articles/workflowsOfRefactoring/) making the change easier, but that wouldn't make sense in this case. Maybe some kind of "Comprehension Refactoring", so renamed `c` to `instruction`. So at least I understood there are instructions, the code loops over them and we do some calculation depending on the elf and a specific instruction. 

## fixing the bug
I used my tests to continue. I executed them seperated with coverage. Especially 1, 2 and 3 adressed my interest, since the seemed to be simplier. Then I recognized that tests 1,2,3,4 and 5 led to the same coverage report and only test 6 - the failing test - contained an elf. Comparing the testdate of test 1 and reading the code I understood the logic - increment or decrement the floor depending on the instruction. Still I was wondering why I'd need a tuple for this and why the code doesn't sum up directly the floors.

Now it was time to look at the second case, when the instructions contain an elf. And I recognized, well it's doing the same counting floors depending on specific instructions. I created another file for a test with simple instructions "(🧝". Based on my understanding the result should have been -2, but it as -6. What's going on? I tried to extract and log the elf with as character than as substring. It took quite sometime to find the correct way of extraction - it's not a char, it's a 2 characters string. So finally substring lead to the correct result. But hey, logging in the else part also logged the `(`. Now it was clear what's going on and I fixed it by adding another else if for `(` and all the tests became green. 

I really wonder that I never used the debugger, instead I used logging. I thought that having a breakpoint in that loop is not so efficient like logging all values and comparing them in the console.

## first refactoring
Finally green, time to start with some clean up Uncle Bob's Boy Scout Rule or Martin Fowler's Litter-Pickup Refactoring. 
* I removed the dead else branch and change the else if to an else = green.
* I extracted to different methods for the calculation depending on the elf and the current instruction => green
* I extracted a method to create the floor calculation Function and replaced the if in the loop with my function object => green
* I implemented a parallel change with the Java stream API. It took quite some time until it compiled (I needed a cast to char and an additional mapToInt in my stream operations) => of course green because the result used still the old logic
* I used my stream implementation to calculate the result => green
* Removed the dead code with the old logic, so got rid of the List of Pairs = green
* Still unhappy with the multiple mappings in my stream, I was able to simplified it to only 1 map operation (thanks to Baeldung and Stack Overflow, CoPilot failed) => green
* Reordered the methods and fixed warnings, which were indicated during commit by IntelliJ => green

I still wasn't satisfied but it seemed to be enough reafctroing at this point in time. Still the tests would need to be improved and maybe some other minor improvement, so I commited and pushed the code. 

## final refactoring steps
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





