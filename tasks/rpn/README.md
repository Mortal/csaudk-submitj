Reverse Polish Notation
=======================

**Task ID: `"rpn"`**

When writing an arithmetic formula such as 1 - (2 * 3) in
[*Reverse Polish notation* (RPN)](https://en.wikipedia.org/wiki/Reverse_Polish_notation),
we write the operator, e.g. minus, *after* the operands.
To multiply 2 by 3, we write `2 3 *` instead of `2 * 3`.

The formula `1 - (2 * 3)` becomes `1 (2 3 *) -`,
and we may remove the parentheses, resulting in `1 2 3 * -`,
since there is no ambiguity about where they should be placed.

A formula written in RPN can be evaluated using a calculator and a stack in the following way:
Read the formula from left to right.

* When you encounter a number, push it on the stack.
* When you encounter an operator, remove the two top elements on the stack,
  compute the operation (plus, minus, times), and push the result on the stack.

For example, consider the expression

* (20 - (2 * (3 + 5))) * (2 - 4)

which, when written in RPN, becomes

* 20 2 3 5 + * - 2 4 - *

When you read the 11 symbols from left to right, the stack changes as follows:

* Push: 20
* Push: 20 2
* Push: 20 2 3
* Push: 20 2 3 5
* Plus: 20 2 8
* Times: 20 16
* Minus: 4
* Push: 4 2
* Push: 4 2 4
* Minus: 4 -2
* Times: -8

In this exercise you must implement a class named `ReversePolishCalculator` with the following methods:

* `void push(int n)` -> pushes *n* on the stack
* `void plus()` -> pops the two top elements from the stack and pushes their sum
* `void minus()` -> pops the two top elements from the stack and pushes their difference
* `void times()` -> pops the two top elements from the stack and pushes their product
* `int read()` -> returns the top element from the stack (without removing it)

Your implementation is allowed to throw an exception if a method is called at a
wrong time, for instance if `read()` is called when the stack is empty or if
`plus()` is called when the stack has fewer than two elements.

Note that for `minus`, the top element on the stack should be subtracted from
the second-from-top element.
In the previous example, the top of stack was the rightmost element.

**Concretely,** you should use the skeleton
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/rpn/ReversePolishCalculator.java">
`ReversePolishCalculator.java`</a>,
the test file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/rpn/RPNTest.java">
`RPNTest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").
You must implement the methods `push`, `plus`, `minus`, `times`, and `read` in `ReversePolishCalculator`,
and you are allowed to add your own private fields to the class.

**Scoring:**

  * 1 point for correct algorithm
