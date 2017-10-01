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
| New queue | `Deque<Integer> q = new ArrayDeque<>();` | O(1) |
| Push *x* | `q.addLast(x);` | O(1) |
| Get front (when empty, throws exception) | `int f = q.getFirst();` | O(1) |
| Get front (when empty, returns null) | `Integer f = q.peekFirst();` | O(1) |
| Pop | `q.removeFirst();` | O(1) |

Using Deque as a stack
----------------------

| Operation | Java code | Complexity |
| --- | --- | --- |
| New stack | `Deque<Integer> q = new ArrayDeque<>();` | O(1) |
| Push *x* | `q.addLast(x);` | O(1) |
| Get top of stack (when empty, throws exception) | `int f = q.getLast();` | O(1) |
| Get top of stack (when empty, returns null) | `Integer f = q.peekLast();` | O(1) |
| Pop | `q.removeLast();` | O(1) |
