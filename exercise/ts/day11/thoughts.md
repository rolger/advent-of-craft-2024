# Thoughts of day 8

## first impressions
I just looked at the challenge in discord. Well there are quite a lot of tests. I have been influenced by a comment about stryker. I have been thinking about mutation testing when I read the instructions, too.

## steps
First, I run jest with coverage and the test achieved 95% statement coverage and 91.66% branch coverage. The missing branch is the default case in the switch statement. So the question is there a way to fake an enum value in TypeScript?
I tried passing a string to the function, but it didn't work. I'm going to ask the internet for help. I didn't find a solution, so I asked CoPilot. It suggested to use a type cast. The result was 100% coverage for all types of coverage.

Second, I reviewed the tests and the code.
* `prepareGifts`: the test data permutes all edge cases and boundary values for `numberOfGifts`. 
* `prepareGifts`: the test data permutes only one representative of all equivalence classes values for `age`. Here we should add the boundary values, too
* `toyType`: the test data passes all possible values for `toyType`.

Third, I installed stryker and run it. 4 mutants survived. I checked the report and the mutants.
* `prepareGifts`: 3 mutants EqualityOperator survived - as expected the edge cases and boundary values for `age` are not covered 
* `toyType`: 1 mutant ConditionalExpression survived in the covered default statement, I don't know why

I'm not able to fix the mutant in `ensureToyBalance` with new tests.

```javascript
        switch (toyType) {
            case ToyType.EDUCATIONAL:
                return typePercentage >= 0.25;
            case ToyType.FUN:
                return typePercentage >= 0.30;
            case ToyType.CREATIVE:
                return typePercentage >= 0.20;
            default:
                return false;
        }
```

I tried to change the code, this killed the mutator.
```javascript
        switch (toyType) {
            case ToyType.EDUCATIONAL:
                return typePercentage >= 0.25;
            case ToyType.FUN:
                return typePercentage >= 0.30;
            case ToyType.CREATIVE:
                return typePercentage >= 0.20;
        }
        return false;
```

But now I get a warning `ureachable code`. If I remove the statement, everything is fine. Strange. I decided to keep the code as it is.
