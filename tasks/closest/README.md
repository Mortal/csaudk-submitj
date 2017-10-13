Closest pair
============

**Task ID: `"closest-2"`**

In this problem, the input to your program is an array of N integers,
and your program must output the smallest difference between two numbers in the input.
For instance, if the input array contains these ten elements
```
  31, -41, 57, 26, -53, 59, 97, -93, -23, 84
```
then your program should return the difference `2 = 59 - 57`.

**Concretely,** you must implement a public method named
`computeClosest` that takes an `ArrayList<Integer> input` as argument
and returns an `int`.
Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/closest/Closest.java">
`Closest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 2 ≤ N ≤ 100 000
  * Each element is between -1 000 000 000 and 1 000 000 000

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct and fast algorithm

An O(N log N) solution is fast enough to get the extra point.


Hint for the fast solution
--------------------------

You are allowed to use `Collections.sort()`
to sort the input list (or any list you may create as part of your solution).

That is, after running `Collections.sort(input);` in `computeClosest()`,
the `input` list is sorted into ascending order.
This might be useful to you when solving the exercise.

Remember to have `import java.util.*;` in the beginning of your solution
in order to be able to use `Collections.sort()`
(which is defined in `java.util`).
