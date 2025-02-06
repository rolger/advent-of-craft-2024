# Thoughts of day 12

## first impressions
This time I tried following some of the hints, refactoring forth and back. I'm not satisfied with the result. There were too many long-lasting changes, 
a lot of manual steps and the code was broken for a long time. 

My new approach is to try to select the topics from Object Calisthenics step by step and apply them to the code.

## list of topics

* replace List<Child> childrenRepository with first class collection ChildRepository
* extract an interface ChildRepository and inject it into Santa
* One Dot per Line in class Santa => no getter for wishlist in class Child
* replace string with Behavior enum
* replace List<Toy> wishlist with first class collection ToyWishlist

## steps

Implement the first class collection ChildRepository, but then I extracted an interface. The class Santa should not know about the implementation, 
only the interface. It's defining the contract and gets the implementation injected. This leads to the next step, the Dependency Inversion Principle 
and adoptions in the tests.

After refactoring the ChildRepository, I started with "One Dot per Line". I moved the retrieval of the wish to the Child class. Well and this leas 
to removing the getter of the wishlist.

Finally, I replaced the enum Behavior with a strategy pattern. Now the strategy decides which toy to give to a child. I like this solution, but the 
process of refactoring was not smooth. I had to change a lot of code and the tests were broken for a long time.