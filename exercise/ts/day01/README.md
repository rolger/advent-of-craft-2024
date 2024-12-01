## first thoughts
The described problem indicates two possible code smells:

* Long Parameter List
* Primitive Obsession

Something else I recognized, the problem is only about two parameters pairs 1st and 2nd, 3rd and 4th. Maybe we can reduce it to the 3rd and 4th, since strings are more obvious to differentiate than numbers. Especially if the numbers have similar values.

I'm wondering if I could fix Santa's original problem just by introducing types. But then I'd just introduce redundant type aliases, and it doesn't fix the problem of using it in the wrong order, since the type are matched up automatically to numbers. Instead I could use classes/records, that would fix it but still they are redundant aliases as long I don't find any additional meaning to it (somebody mentioned ValueObject). 

## grouping parameters
The Long Parameter List means to group parameter, there are quite a log to combinations:

numbersOfDaysForComingBack, numberOfDaysBeforeChristmas: no idea for a meaningful 
name and context

=> 'numberOfDaysBeforeChristmas' makes no sense to group with the others

reindeerName: could become a class Reindeer
currentLocation, numbersOfDaysForComingBack: looks like a Location class
reindeerName, currentLocation, numbersOfDaysForComingBack: also Reindeer, but why should a Reindeer have a location? Need to ask business what a Reindeer means to them. Or is it a ReindeerLocation?

=> decided to choose ReindeerLocation, because it's more likely that a Reindeer has a location than the other way around

## alternative ideas
'numberOfDaysToRest' is passed to the ctr, I assume it's a systems constant at least for the life of the communicator. So I asked myself why not the same for 'numberOfDaysBeforeChristmas'. But moving 'numberOfDaysBeforeChristmas' to class level would improve the issue to the ctr :-(, well then only one place remains to refactor. I decided against this solution, because I don't have enough criterias to decide if the commicator has a life time of multiple days or not.

'numberOfDaysToRest' dependends on today and Christmas Eve, so somebody has to calculate it. I could introduce a interface with a method and than pass it to th ctr. Well it fixed the issue with the parameter list, but I feel some over enginnering. I don't know enough about it's usages.