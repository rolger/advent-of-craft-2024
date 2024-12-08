# Thoughts of day 8

## first impressions
I've been sick and busy the last days. Now I'm really happy to continue toady. Especially because today's topic is "Tell DOnt Ask". A quick sneak preview on the description of the exercise and the code reminded me of an anemic domain model. I'm curious to see how the code will evolve.

I chose Java today, since it's the easiest for me to get started with. 


## steps

I started with executing the tests and checked the coverage. There is only one branch that is not covered when the read toy is null. I won't care about that.

I checked the code. I'm going to move the state change to the `Toy` class. I'm wondering why the save happens inside the if statement. 

Next I asked my self to adapt the test, it is currently an integration test. Shall I change it to a unit test? I think I will keep it as it and implement a Unit Test for the `Toy` class.

I named the method `assignToElf` since the service has a similar name. I'm not sure if this is a good name, because there is no elf involved. I return a boolean to indicate if the toy was assigned. I don't like this, but I will keep it for now.

## alternative ideas

Instead of returning a boolean I could set a state in the toy. Then the repository could check if the save action is necessary. This would clean the code in the service. But I don't like to implement some kind of persistence logic manually.

I'll give it a try in a second commit and see how it feels.










