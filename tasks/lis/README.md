Longest increasing subsequence
==============================

**Task ID: `"lis"`**

See also CLRS exercise 15.4-5.

Given a list of *N* numbers `a_1`, ..., `a_n`,
we let L(i) denote the length of the longest increasing subsequence of `a_1`, ..., `a_i`
where `a_i` is the last element in the subsequence.

**Example:** For the list of numbers `2, 5, 3, 4, 1`, we have N = 5 and L(4) = 3 since the list `2, 5, 3, 4` contains the increasing subsequence `2, 3, 4`.

L(i) can be determined from the following recurrence, where 0 ≤ i ≤ N,
and we set `a_0 = -∞` to make the formula valid when j = 0:

```
       ⎧                       0                     if i = 0
L(i) = ⎨
       ⎩ 1 + max { L(j) | 0 ≤ j < i and a_j < a_i }  if i > 0
```

In this problem you should implement an algorithm based on dynamic programming
to compute the longest increasing subsequence in a list of *N* numbers.

**Concretely,** you must implement a public method named
`longestIncreasingSubsequence` that takes an `ArrayList<Integer> input` as argument
and returns an `ArrayList<Integer>`.

Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/lis/LongestIncreasingSubsequence.java">
`LongestIncreasingSubsequence.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 1 ≤ N ≤ 2000
  * Each element is between -1 000 000 000 and 1 000 000 000

**Scoring:**

  * 1 point for correct and fast algorithm

An O(N²) solution based on the above dynamic programming formula is fast enough to get the point.

If you are looking for a challenge, then you may try to come up with an
O(N log N) solution for this problem!
See also CLRS exercise 15.4-6.
