Inversions
==========

**Task ID: `"inversions-2"`**

In this task you must implement an algorithm to count the inversions in a list of N integers from 1 to N.

For instance, if the input is the list
```
  1, 4, 2, 3
```
then your program must output 2, since the list contains the two inversions (4,2) and (4,3).

If the input is the list
```
  5, 4, 3, 2, 1
```
then your program must output 10, since the list contains 4+3+2+1 inversions.

Concretely, you must implement a public method named
`countInversions` that takes an `ArrayList<Integer> input` as argument
and returns an `int`.
Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/inversions/Inversions.java">
`Inversions.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 1 ≤ N ≤ 65 536
  * Each element is between 1 and N
  * Each number between 1 and N occurs exactly once in the list, i.e. there are no duplicate elements
  * The number of inversions fits in a Java `int` without overflowing

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct O(N log N) algorithm
