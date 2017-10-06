Max-priority queue
==================

To change a [PriorityQueue](PriorityQueue.md) from a min-heap to a max-heap,
you need to specify the `Comparator` that reverses the ordering of elements.
This is available as `Collections.reverseOrder()`.

You can construct a max-heap as follows:

```
PriorityQueue<Integer> heap = new PriorityQueue<>(11, Collections.reverseOrder());
```

The max-heap supports the same [operations as the min-heap](PriorityQueue.md)
but with operations involving minimal elements
instead operating on maximal elements.
