Dodgeball
=========

**Task ID: `"dodge-2"`**

**Here be dragons! This description is a WORK IN PROGRESS and not yet ready for FADS 2017.**

Crazy Dodgeball is a game in which two teams play against each other using a ball.
At any point in time, the players on your team stand on a line,
and the following two things can happen:

* A new player comes alive and is added to the line at position *x*
* A ball is thrown at position *x*
  * If a ball is thrown at position *x* and there is a player at position *x*,
    that player is out and is removed from the line.
  * Otherwise, the player that is closest to position *x* moves to position *x*
    and throws the ball back at the other team.

In this exercise you must implement a class named `Dodgeball`
with the following methods:

* `void addPlayer(int x)` -> adds a new player at position *x* in the game
* `int throwBall(int x)` -> updates the set of players when a ball is thrown at position *x*

At no point in time are there two players that stand at the same position.

If a ball is thrown at position *x* and there are two players that are both closest to the ball,
that is, they stand at positions *x* − *d* and *x* + *d* for some integer *d*,
then the player with the numerically smallest position moves to the ball.

For example, if there are two players that stand at positions 1 and 7,
and a ball is thrown at position 4, then the player at position 1 moves to position 4.

**Concretely,** you should use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/dodge/Dodgeball.java">
`Dodgeball.java`</a>,
the test file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/dodge/DodgeTest.java">
`DodgeTest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").
You must implement the methods `addPlayer` and `throwBall` in `Dodgeball`,
and you are allowed to add your own private fields to the class.

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct and fast algorithm

An algorithm that spends O(log N) time on `addPlayer()` and `throwBall()`
is fast enough for the extra point.

**Hint** for the fast solution: Use a balanced binary search tree.
