Closest ball
============

**Task ID: `"ball-2"`**

Dodgeball Madness is a game in which two teams of N players play against each other
using M balls. It is your team's turn to play, and you must quickly determine
which of the N players on your team is closest to one of the M balls you can throw,
since the faster your team gets the first throw in, the more likely it is that you
will hit one of the players on the other team!

Since all players and all balls are currently on a straight line,
the distance between a player at position *x* and a ball at position *y*
is simply |*x* - *y*|, that is, the absolute value of the difference
between the two numbers *x* and *y*.

Your task is to write a program that takes the positions of the N players
and the M balls and outputs the shortest distance between a player and a ball.

For instance, if the players are located at positions
```
  95, 66, 82, 63, 17
```
and the balls at positions
```
  75, 38, 25, 77
```
then your program should output `5 = |82 - 77|`.

**Concretely,** you must implement a public method named
`computeClosest` that takes an `ArrayList<Integer> players`
and an `ArrayList<Integer> balls` as arguments
and returns an `int`.
Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/ball/ClosestBall.java">
`ClosestBall.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 1 ≤ N ≤ 100 000
  * 1 ≤ M ≤ 100 000
  * Each element is between 1 and 1 000 000 000

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct and fast algorithm

An O(N log N + M log M) solution is fast enough to get the extra point.

**Hint** for the fast solution: You're allowed to use `Collections.sort()`
just like in [the `closest` exercise](../closest).
