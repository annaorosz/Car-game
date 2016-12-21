=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: aorosz
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. You may copy and paste from your proposal
  document if you did not change the features you are implementing.

Concept 1: Appropriately modeling state using 2-D arrays or collections.

I implemented Collections to keep track of my Stars, my Cars and my high scores.
For the Star and Car Object, I used Hashmaps, since I wanted to have multiple cars and stars on
my Gamecourt and the same time. With the collections, I was able to make sure that there are
3 cars and 3 stars on the Gamecourt at all times.
For my high scores, I implemented Treesets, since Treesets are sorted by default and I needed to 
sort my high scores according to their values. 


Concept 2: Object-oriented design using inheritance and subtyping


I have a class for all my objects but I have a subtype for all of them, Player, Car, Star and 
Explosion.
All my objects have to follow a certain pattern, but my player and the obstacles have
different properties and subtyping helps with that. Both the player and the obstacles have 
a form, sizes, but they will be able to move differently. i.e. The player can only move horizontally
but the obstacles will move vertically.


Concept 3: Using JUnit to test some features of your model.

I tested my edge cases, especially IO, with my JUnit tests.
JUnit will help me test for edge cases, errors, special cases. The IO concept was especially 
difficult to implement for me so this was an essential part of my design.


Concept 4: I/O

I used IO to keep track of the high scores.
I will have a text file where I will keep track of the top 10 scores and I will write the score
(the output) each time to that file. I will also sort these numbers highest to lowest.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  
    Game: My Game class is the main class of the game. Here I instantiate the Gamecourt and
    start the game.
    
    GameCourt: My GameCourt class instantiates all of the objects in my game, including the Player,
    the Car, the Star. It also includes the method that controls the game, reset() and tick().
    
    GameObj: This is the abstract class for every single Object in my Game. Player, Car, Star and
    Explosion are all subtypes of this Object.
    
    Player: This is the class for the Player object. In this case, this is a red car, which the 
    user can control.
    
    Car: This is the class for all the cars in my which are the obstacles. The user has to avoid
    these Car Objects.
    
    Star: This is the class for all the Star Objects in my game. To increase the score, the user 
    has to collect, aka intersect with these stars.
    
    Explosion: This is the class for the Explosion object that appears when the Player and a Car
    intersect.
    
    GameTest and IOTest are both class with JUnits.
    
    Direction: This class includes all of the possible directions the objects can move.


- Revisit your proposal document. What components of your plan did you end up
  keeping? What did you have to change? Why?

    I kept most of my components. I decided to not use a 2-D array for the grid of my Gamecourt, 
    though. Instead, I decided to use Collections to keep track of all the Star and Car Objects,
    as well as the high scores.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  
    I was struggling to implement IO a lot.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?

    My private state is not encapsulated too well. I decided to make most of my variables public
    because I wanted to test my program with JUnit. I needed to access my variables in GameCourt,
    though.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.

