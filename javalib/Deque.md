Deque (double-ended queue)
==========================

The class `Deque<T>` in the Java standard library can be used as a queue and as a stack.

Remember to have the following import statement in your code to use this class:

```
import java.util.*;
```

Using Deque as a queue
----------------------

| Operation | Java code | Complexity |
| --- | --- | --- |
| New queue | `Deque<Integer> queue = new ArrayDeque<>();` | O(1) |
| Push *x* | `queue.addLast(x);` | O(1) |
| Get front (when empty, throws exception) | `int f = queue.getFirst();` | O(1) |
| Get front (when empty, returns null) | `Integer f = queue.peekFirst();` | O(1) |
| Pop | `queue.removeFirst();` | O(1) |

Using Deque as a stack
----------------------

| Operation | Java code | Complexity |
| --- | --- | --- |
| New stack | `Deque<Integer> stack = new ArrayDeque<>();` | O(1) |
| Push *x* | `stack.addLast(x);` | O(1) |
| Get top of stack (when empty, throws exception) | `int f = stack.getLast();` | O(1) |
| Get top of stack (when empty, returns null) | `Integer f = stack.peekLast();` | O(1) |
| Pop | `stack.removeLast();` | O(1) |
