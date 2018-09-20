Inversions
==========

**Task ID: `"inversions-2"`**

Let A[1..N] be an array of N integers.
If i < j and A[i] > A[j], then the pair (i, j) is called an **inversion** of A.
In this task you must implement an algorithm to count the inversions in an array of N integers from 1 to N.

For instance, the list
```
  1, 4, 2, 3
```
contains two inversions, namely (2, 3) and (2, 4),
since A[2] > A[3] and A[2] > A[4].

The list
```
  5, 4, 3, 2, 1
```
has 10 inversions, namely (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), (2, 5), (3, 4), (3, 5), (4, 5).

**Concretely,** you should use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/inversions/Inversions.java">
`Inversions.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").
You must implement a public method named
`countInversions` that takes an `ArrayList<Integer> input` as argument
and returns an `int`.

**Input constraints:**

  * 1 ≤ N ≤ 65 536
  * Each element is between 1 and N
  * Each number between 1 and N occurs exactly once in the list, i.e. there are no duplicate elements
  * The number of inversions fits in a Java `int` without overflowing

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct and fast algorithm

An O(N log N) algorithm is fast enough for the extra point.

Hint for the fast solution
--------------------------

Consider how merge sort works.
You can start by solving Problem 2-4 "Inversions" in [CLRS].
That should help you write the pseudocode of a fast algorithm for counting inversions.
