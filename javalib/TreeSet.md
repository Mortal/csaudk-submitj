Balanced binary search tree - `TreeSet<T>`
==========================================

The Java class `TreeSet` maintains a set of ordered elements
under insertions and deletions.
Typically the elements will be numbers,
but the class is generic and works with any type that implements `Comparable`.

If you need to use a red/black search tree, then you can use a `TreeSet` in Java.

Remember to import the class before using it:

```
import java.util.*;
```

The class supports the following operations:

| Operation | Java code | Time complexity |
| --- | --- | --- |
| New tree | `TreeSet<Integer> tree = new TreeSet<>();` | O(1) |
| Add *x* | `tree.add(x);` | O(log N) |
| Remove *x* | `tree.remove(x);` | O(log N) |
| Does `tree` contain *x*? | `if (tree.contains(x)) { ... }` | O(log N) |
| Predecessor of *x* (see below) | `Integer p = tree.floor(x);` | O(log N) |
| Successor of *x* (see below) | `Integer s = tree.ceiling(x);` | O(log N) |

The predecessor and successor operations work as follows:
If *x* is contained in `tree`, then `tree.floor(x)` and `tree.ceiling(x)` both return *x* itself.
Otherwise, the methods return the **predecessor** and **successor** of *x* defined as follows:

* The **predecessor** of *x* is the largest element *y* in the tree that is less than or equal to *x*
  * The definition can be written as the mathematical formula: *y* = max { *z* ∈ tree | *z* ≤ *y* }
  * If *x* is less than all elements in the tree, then the predecessor of *x* is `null`.
* The **successor** of *x* is the smallest element *y* in the tree that is greater than or equal to *x*
  * The definition can be written as the mathematical formula: *y* = min { *z* ∈ tree | *z* ≥ *y* }
  * If *x* is greater than all elements in the tree, then the successor of *x* is `null`.

For example, if the tree contains the elements:

```
  { 1, 3, 6, 10, 15 }
```

... then the predecessor of 2 is 1 and the successor of 2 is 3.
The predecessor and successor of 10 is just 10 since 10 is contained in the set.
The predecessor of 0 is `null`.
