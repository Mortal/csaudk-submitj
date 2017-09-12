Max delsum
==========

**Problem ID: `maxdelsum-2`**

This problem is based on *Bentley* Chp. 8.

In this problem, the input to your program is an array of N integers,
and your program must output the maximum sum found
in any *contiguous* subarray of the input.
For instance, if the input array contains these ten elements
```
  31, -41, 59, 26, -53, 58, 97, -93, -23, 84
```
then your program should return the sum `187 = 59 + 26 + (-53) + 58 + 97`.

Concretely, you must implement a public method named
`maxdelsum` that takes an `ArrayList<Integer> list` as argument
and returns an `int`.
Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/maxdelsum/Maxdelsum.java">
`Maxdelsum.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 1 ≤ N ≤ 100 000
  * Each element is between -50 000 and 50 000
  * Every subarray sum fits in a Java `int` without overflowing

**Scoring:**
This demo exercise doesn't count towards your grade in FADS 2017.

  * 1 point for correct algorithm
  * 1 extra point for correct linear-time algorithm
