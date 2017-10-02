PriorityQueue - min-heap/max-heap
=================================

The Java class `PriorityQueue` maintains a set of ordered elements
under insertions and remove-minimum operations.
Typically the elements will be numbers,
but the class is generic and works with any type that implements `Comparable`.

If you need to use a heap, then you can use a `PriorityQueue` in Java.

Remember to import the class before using it:

```
import java.util.*;
```

By default the `PriorityQueue` implements a min-PriorityQueue,
that is, the smallest element is returned by the remove operation.
If you need a max-heap, you need to
[specify your own comparator](maxheap.md).

| Operation | Java code | Time complexity |
| --- | --- | --- |
| New heap | `PriorityQueue<Integer> heap = new PriorityQueue<>();` | O(1) |
| Add *x* | `heap.add(x);` | O(log N) |
| Get minimum element | `Integer m = heap.peek();` | O(1) |
| Remove minimum element | `heap.poll();` | O(log N) |
| Number of elements | `int size = heap.size();` | O(1) |

The `peek()` method returns `null` if the heap is empty.
