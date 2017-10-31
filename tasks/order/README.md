Order-statistic tree
====================

**Task ID: `"order"`**

In this exercise you should augment a red-black search tree
to become an order-statistic tree.

Further reading: CLRS Section 14.1.

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

**Your task** is to implement the following methods:

* `Augment.leaf()` - this method should create a new `Augment` object
  containing augmented data for a leaf in the tree
* `Augment.combine(Augment left, Augment right, int key)` - this method should
  create a new `Augment` object containing augmented data for an internal node
  in the tree, where `left` and `right` are the `Augment` objects stored with
  the node's children, and `key` is the key stored in the node.
* `RedBlackTree.select(Node x, int rank)` - this method should return the Node
  in the subtree of `x` that would be printed after the first `rank` nodes
  in an in-order traversal of `x`.
* `RedBlackTree.rank(Node x)` - this method should return the rank of `x`,
  that is, the position of `x` in an in-order traversal of the tree.

If you are unsure of how to solve the exercise, then you should read CLRS Section 14.1.

**Concretely,** you should use the skeleton files

* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/order/RedBlackTree.java">
  RedBlackTree.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/order/Node.java">
  Node.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/order/Augment.java">
  Augment.java</a>,
* <a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/order/Color.java">
  Color.java</a>,

the test file
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/tasks/order/OrderStatisticTest.java">
`OrderStatisticTest.java`</a>
and the
<a href="https://github.com/Mortal/csaudk-submitj/raw/master/Submit.java">
`Submit` program</a>
inside BlueJ (right click and choose "Save link as").

**Scoring:**

  * 1 point for correct implementation
