Maze multirouting
=================

**Task ID: `"mazepair-2"`**

In this exercise you must compute the shortest path
between a runner and a ball in a maze
that has many runners and many balls.
A maze is an H-by-W matrix `A` (H rows, W columns),
where each cell `A[i][j]` (0 ≤ i < H, 0 ≤ j < W)
is either a `'.'` (free space), a `'o'` (wall),
a `'r'` (runner), or a `'b'` (ball). Example 1:

```
ooooooooooooo
o.o.o.....obo
o.o.ooo.ooo.o
o...r...o...o
ooooo.o.o.ooo
o.....o.....o
o.ooooooo.o.o
o.ooo.oboro.o
o...o.ooooo.o
ooo.o.......o
o.....b.ooo.o
ooooooooooooo
```

We can model the maze as a graph as follows.
The vertices of the graph are the pairs `(i, j)` where `A[i][j] != 'o'`,
and the edges out of a vertex `(i, j)` are
the four neighbors `(i-1, j)`, `(i+1, j)`, `(i, j-1)`, `(i, j+1)`,
except where the neighbor is a wall `'o'`.

The number of vertices and edges is O(W·H)
(you should convince yourself that this is true).

The length of a path is simply the number of edges in the path.

In Example 1, the shortest path consists of 9 vertices,
which means that the shortest path has length 8.
The shortest path is indicated by plus signs for clarity:

```
ooooooooooooo
o.o.o.....obo
o.o.ooo.ooo+o
o...r...o+++o
ooooo.o.o+ooo
o.....o..+..o
o.ooooooo+o.o
o.ooo.oboro.o
o...o.ooooo.o
ooo.o.......o
o.....b.ooo.o
ooooooooooooo
```

Example 2:

```
ooooooooooooo
o...o.......o
oooro.o.ooo.o
o...o.o....bo
o.o.o.ooooo.o
oro.o.....o.o
o.o.o.ooo.ooo
o.o...o...o.o
o.o...obo.o.o
o...o.o.....o
ooooooooooooo
```

In this example, the shortest path from a runner to a ball has length 18:

```
ooooooooooooo
o...o.......o
oooro.o.ooo.o
o..+o.o....bo
o.o+o.ooooo.o
oro+o+++++o.o
o.o+o+ooo+ooo
o.o+++o+++o.o
o.o...obo.o.o
o...o.o.....o
ooooooooooooo
```

Note that we are only interested in finding the closest pair of runner and ball.

**Concretely,** you must implement a method named
`shortestPath` that accepts a `char[][] maze` as parameter
and returns an `int` indicating the length of the shortest path
from a runner to a ball
or `Integer.MAX_VALUE` if there is no path between any runner and any ball.

Use the skeleton file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mazepair/MazePair.java">
`MazePair.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 3 ≤ W, H ≤ 1000
  * Each `maze[i][j]` is either `'.'`, `'o'`, `'r'` or `'b'`
  * There is at least one `'r'` and at least one `'b'`
  * The first row, last row, first column, and last column
    all consist of walls (`'o'`)

**Scoring:**

  * 1 point for correct implementation
  * 1 additional point for fast implementation

For the first point, an O(R·W·H) algorithm is fast enough,
where R is the number of runners in the input.
For the additional point, an O(W·H) algorithm is required.
