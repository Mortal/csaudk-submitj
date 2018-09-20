Longest palindrome subsequence
==============================

**Task ID: `"pal"`**

See also: CLRS Problem 15-2.

A string is a palindrome if the string is equal to its reversal.

In this problem you are given a string `T[1..N]` of length *N*,
and your task is to compute the longest subsequence of T which is a palindrome.

Let L(i, j) denote the length of the longest palindrome subsequence of `T[i..j]`.

**Example:** For the string `T = bcabcaba` of length 8, L(3, 8) = 5
since the string `T[3..8] = abcaba` contains the palindrome `abcba` as a subsequence.

L(i, j) can be determined from the following recurrence, where 1 ≤ i ≤ N and 1 ≤ j ≤ N:

```
          ⎧             0              if j < i
          ⎪
          ⎪             1              if i = j
L(i, j) = ⎨
          ⎪      2 + L(i+1, j-1)       if i < j and a_i = a_j
          ⎪
          ⎩ max(L(i+1, j), L(i, j-1))  if i < j and a_i ≠ a_j
```

In this problem you should implement an algorithm based on dynamic programming
to compute the longest palindrome subsequence in a list of *N* numbers.

**Concretely,** you must implement a public method named
`longestPalindromeSubsequence` that takes an `ArrayList<Character> input` as argument
and returns an `ArrayList<Character>`.

Use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/pal/LongestPalindromeSubsequence.java">
`LongestPalindromeSubsequence.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 1 ≤ N ≤ 2000

**Scoring:**

  * 1 point for correct and fast algorithm

An O(N²) solution based on the above dynamic programming formula is fast enough to get the point.
