Max-priority queue
==================

To change a [PriorityQueue](PriorityQueue.md) from a min-heap to a max-heap,
you need to specify your own `Comparator` that reverses the ordering of elements.

You may add this class to your Java project:

```
public class GreaterCompare implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b.compareTo(a);
    }
}
```

Then you can construct a max-heap as follows:

```
PriorityQueue<Integer> queue = new PriorityQueue<>(11, new GreaterCompare());
```

The max-heap supports the same [operations as the min-heap](PriorityQueue.md)
but with operations involving minimal elements
instead operating on maximal elements.
