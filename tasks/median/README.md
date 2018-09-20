Median data structure
=====================

**Task ID: `"median-2"`**

In this exercise you should implement a data structure named `Median`
that supports the two operations:

* `void add(int v)` - add a number to the data structure
* `int median()` - return the median of the numbers in the data structure

In this exercise, the **median** of a set of *N* numbers is the number in the
set that comes after the first *N*/2 (rounded down) numbers in the sorted order.
In Java, this means that the median is the element at index `N / 2` in the sorted order
(since integer division in Java rounds down, and Java uses 0-based indexing).

**Example 1**: If the set contains the numbers:

```
  2, 5, 3, 7
```

then the sorted order is `[2, 3, 5, 7]`, so the median is 5.

**Example 2**: If the set contains the numbers:

```
  2, 4, 7, 9, 3
```

then the median is 4.

**Example 3**: Note that the median is not necessarily close to the average. For instance, if the set contains the numbers:

```
  32, 59, 32673, 58586, 14162, 288, 411
```

then the median is 411 (although the average is 15173).

**Concretely,** you should use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/median/Median.java">
`Median.java`</a>,
the test file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/median/MedianTest.java">
`MedianTest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").
You must implement the methods `add` and `median` in `Median`,
and you are allowed to add your own private fields to the class.

**Input constraints:**

  * Number of insertions is at most 500000
  * All numbers added are distinct (that is, the same number is not added multiple times to the data structure)
  * Each number is an integer between 1 and 1000000000
  * The first operation is `add()`

**Scoring:**

  * 1 point for correct algorithm
  * 1 extra point for correct and fast algorithm

An algorithm that spends O(log N) time per operation
is fast enough for the extra point.

**Hint** for the fast solution: Use two priority queues
OR use a balanced binary search tree.
