

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
- wrong sex: 09800867, 49800867
- not a year: a1
- to short: 12777
- to long: 12777127771277712777
- wrong serial number: 19800i67, 19800067
- incorrect checksum: 31213299


what is my API?
I'd go for a validate function that returns a boolean.

which is my first test? 
Shall I start with a valid or invalid EID? when I start with an invalid EID, I've the feeling it will not become red anymore.
