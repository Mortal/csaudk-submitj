Maze routing
============

**Task ID: `"maze"`**

In this exercise you must compute the shortest path in a maze
from the top left corner to the bottom right corner.
A maze is an H-by-W matrix `A` (H rows, W columns),
where each cell `A[i][j]` (0 ≤ i < H, 0 ≤ j < W)
is either a `'.'` (free space) or a `'o'` (wall):

```
ooooooooooooo
o.o.o.....o.o
o.o.ooo.ooo.o
o.......o...o
ooooo.o.o.ooo
o.....o.....o
o.ooooooo.o.o
o.ooo.o.o.o.o
o...o.ooooo.o
ooo.o.......o
o.......ooo.o
ooooooooooooo
```

We can model the maze as a graph as follows.
The vertices of the graph are the pairs `(i, j)` where `A[i][j] == '.'`,
and the edges out of a vertex `(i, j)` are
the four neighbors `(i-1, j)`, `(i+1, j)`, `(i, j-1)`, `(i, j+1)`,
except where the neighbor is a wall `'o'`.

The number of vertices and edges is O(W·H)
(you should convince yourself that this is true).

The length of a path is simply the number of edges in the path.

In the example above, the shortest path consists of 20 vertices,
which means that the shortest path has length 19:

```
ooooooooooooo
oxo.o.....o.o
oxo.ooo.ooo.o
oxxxxxxxo...o
ooooo.oxo.ooo
o.....oxxxxxo
o.ooooooo.oxo
o.ooo.o.o.oxo
o...o.oooooxo
ooo.o......xo
o.......oooxo
ooooooooooooo
```

**Concretely,** you must implement a method named
`shortestPath` that accepts a `char[][] maze` as parameter
and returns an `int` indicating the length of the shortest path
from `maze[1][1]` to `maze[H-2][W-2]`
(where `H = maze.length` and `W = maze[0].length`),
or `Integer.MAX_VALUE` if there is no path.

Use the skeleton file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/maze/Maze.java">
`Maze.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * 3 ≤ W, H ≤ 1000
  * Each `maze[i][j]` is either `'.'` or `'o'`
  * `maze[1][1]` and `maze[H-2][W-2]` are both equal to `'.'`.
  * The first row, last row, first column, and last column
    all consist of walls (`'o'`)

**Scoring:**

  * 1 point for correct and fast implementation

An O(W·H) algorithm is fast enough.
