Queue simulation
================

**Task ID: `"queue"`**

**Here be dragons! This description is a WORK IN PROGRESS and not yet ready for FADS 2017.**

In this problem, the input to your program is an array of N integers,
and your program should repeat the following operation as long as there are at least two integers:

* Remove the first two integers from the list and add the second one back to the end of the list.

When there is just one integer left, your program should return it.

For example, if the input is the list

```
  1 2 3 4 5
```

then your program should perform the above operation four times:

* After the 1st operation, the list contains: 3 4 5 2
* After the 2nd operation, the list contains: 5 2 4
* After the 3rd operation, the list contains: 4 2
* After the 4th operation, the list contains: 4

That means your program should return 4.

Concretely, you must implement a public method named
`simulate` that takes an `ArrayList<Integer> input` as argument
and returns an `int`.
Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/queue/QueueSimulation.java">
`QueueSimulation.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Scoring:**

  * 1 point for correct and fast algorithm

**Hint:** An O(N) time algorithm is fast enough, so your program should use a queue data structure.
If you only use an ArrayList, your program might take O(N²) time and not be fast enough.
