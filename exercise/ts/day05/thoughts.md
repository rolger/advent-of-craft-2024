# Thoughts on day 5

## first impression
I don't understand the requirements. 

**Design a system that can handle EID**

I understood the technical composition of EID but what shall I implement? What is the API? So, I looked at the solution and looks like we should implement a validate function.

## examples

Examples of EIDs:

Valid EID: 
- 7. elf in 1998 Sloubi:   
    19800767 (67 = (97 - (198007 % 97))
- 8. elf in 1998 Gagna:
    29800867 (73 = 97 - (298008 % 97))
- 132. elf in 2012 Catact: 
    31213214 (14 = 97 - (312132 % 97))

Invalid EID:
- null, ""
- to short: 12777
- to long: 12777127771277712777
- wrong sex: 09800867, 49800867
- not a year: a1
- wrong serial number: 19800i67, 19800067
- incorrect checksum: 31213299


what is my API?
I'd go for a validate function that returns a boolean.

which is my first test? 
Shall I start with a valid or invalid EID? when I start with an invalid EID, I've the feeling it will not become red anymore. So, I start with the empty EIDs.

## final thoughts
TDD went well. There was no need for debugging the code. Only my last step was to big. I should have added tests for invalid values of keys, then I could be safe that the substring was correctly implemented.

