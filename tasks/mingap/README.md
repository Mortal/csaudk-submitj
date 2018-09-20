Dynamic min-gap
===============

**Task ID: `"mingap"`**

In this exercise you should augment a red-black search tree
so that it can report the *minimum gap*,
which is the smallest difference between two numbers in the tree.

Further reading: CLRS Exercise 14.3-6.

For instance, if the red-black search tree contains these ten elements
```
  23, 26, 31, 41, 53, 57, 59, 84, 93, 97
```
then the min-gap is the difference `2 = 59 - 57`.

You are given a class named *RedBlackTree*
with working implementations of the following fields and methods:

* `tree.insert(int k)` - inserts a node with key *k* into the red-black tree
* `tree.erase(int k)` - removes a node with key *k* from the red-black tree
* `tree.find(int k)` - returns a reference to a node with key *k*
* `tree.root` - a reference to the root node of the tree

You should not modify the above methods or any of the helper methods
`rotate_left()`, `rotate_right()` and `update_augments_to_root()`.

The nodes are implemented by the class named *Node* with the following fields
and methods:

* `node.key` - the key stored in the node
* `node.left` - a reference to the node's left child, or `null` if the left child is a leaf
* `node.right` - a reference to the node's right child, or `null` if the right child is a leaf
* `node.parent` - a reference to the node's parent, or `null` if the node is the root
* `node.color` - the node's color, either `Color.RED` or `Color.BLACK`
* `node.isLeftChild()` - returns true if the node is its parent's left child
* `node.isRightChild()` - returns true if the node is its parent's right child

We have implemented part of the augmentation of the red-black tree for you,
so each node additionally has the following fields and methods:

* `node.augment` - an object of type `Augment`
* `node.getLeftAugment()` - returns the left child's `Augment` object, or `Augment.leaf()` if it has no left child
* `node.getRightAugment()` - returns the right child's `Augment` object, or `Augment.leaf()` if it has no right child

**Your task** is to implement the following methods in the `Augment` class:

* `Augment.leaf()` - this method should create a new `Augment` object
  containing augmented data for a leaf in the tree.
  Remember that a leaf in a red-black tree corresponds to an empty subtree containing no keys.
* `Augment.combine(Augment left, Augment right, int key)` - this method should
  create a new `Augment` object containing augmented data for an internal node
  in the tree, where `left` and `right` are the `Augment` objects stored with
  the node's children, and `key` is the key stored in the node.

The `Augment` class must have a public field named `minGap`,
and you are allowed to add any additional fields in `Augment`
that you might need to maintain.

The `minGap` field of a node's augment object
should contain the smallest difference between two numbers
in the node's subtree.

**Hint:** Add two fields named `min` and `max` to `Augment`,
and maintain that `min` contains the smallest key in the subtree
and `max` the largest key in the subtree.

You should think about how to compute `minGap`
from `left.minGap`, `left.min`, `left.max`, `right.minGap`, `right.min`, `right.max`, and `key`.

**Concretely,** you should use the skeleton files

* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mingap/RedBlackTree.java">
  RedBlackTree.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mingap/Node.java">
  Node.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mingap/Augment.java">
  Augment.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mingap/Color.java">
  Color.java</a>,

the test file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/mingap/MinGapTest.java">
`MinGapTest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Input constraints:**

  * The same number is not added more than once to the red-black tree
  * Each element is an integer between 1 and 1,000,000,000

**Scoring:**

  * 1 point for correct implementation
