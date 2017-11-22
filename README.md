# Car game
# Author: Anna Orosz

## Classes

### Game: 
My Game class is the main class of the game. Here I instantiate the Gamecourt and
start the game.

### GameCourt: 
My GameCourt class instantiates all of the objects in my game, including the Player,
the Car, the Star. It also includes the method that controls the game, reset() and tick().

### GameObj: 
This is the abstract class for every single Object in my Game. Player, Car, Star and
Explosion are all subtypes of this Object.

### Player: 
This is the class for the Player object. In this case, this is a red car, which the 
user can control.

### Car: 
This is the class for all the cars in my which are the obstacles. The user has to avoid
these Car Objects.

### Star: 
This is the class for all the Star Objects in my game. To increase the score, the user 
has to collect, aka intersect with these stars.

### Explosion: 
This is the class for the Explosion object that appears when the Player and a Car
intersect.

### GameTest and IOTest:
are both class with JUnits.

### Direction: 
This class includes all of the possible directions the objects can move.


## Concepts

### 2-D arrays or collections.

I implemented Collections to keep track of my Stars, my Cars and my high scores.
For the Star and Car Object, I used Hashmaps, since I wanted to have multiple cars and stars on
my Gamecourt and the same time. With the collections, I was able to make sure that there are
3 cars and 3 stars on the Gamecourt at all times.
For my high scores, I implemented Treesets, since Treesets are sorted by default and I needed to 
sort my high scores according to their values. 


### Object-oriented design using inheritance and subtyping

I have a class for all my objects but I have a subtype for all of them, Player, Car, Star and 
Explosion.
All my objects have to follow a certain pattern, but my player and the obstacles have
different properties and subtyping helps with that. Both the player and the obstacles have 
a form, sizes, but they will be able to move differently. i.e. The player can only move horizontally
but the obstacles will move vertically.

### Using JUnit to test some features of your model.

I tested my edge cases, especially IO, with my JUnit tests.
JUnit will help me test for edge cases, errors, special cases. The IO concept was especially 
difficult to implement for me so this was an essential part of my design.


### I/O

I used IO to keep track of the high scores.
I will have a text file where I will keep track of the top 10 scores and I will write the score
(the output) each time to that file. I will also sort these numbers highest to lowest.



