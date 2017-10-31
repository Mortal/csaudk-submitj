// Version: 2017103101
import java.util.NoSuchElementException;
public class RedBlackTree {

    private Node root;

    public int minGap() {
        return root.augment.minGap;
    }

    public Node find(int key) {
        Node z = root;
        while (z != null && z.key != key) {
            if (key < z.key) z = z.left;
            else z = z.right;
        }
        if (z == null)
            throw new NoSuchElementException("No node with key " + key + " present.");
        return z;
    }

    public void insert(int key) {
        // Find insertion point of 'key' in binary search tree.
        Node x, y;
        x = root;
        y = null;
        // Invariant: y is x's parent.
        while (x != null) {
            y = x;
            if (key < x.key) x = x.left;
            else x = x.right;
        }
        // Insert 'key' under 'y'.
        Node n = new Node(key);
        if (y == null) {
            root = n;
        } else if (key < y.key) {
            y.left = n;
        } else {
            y.right = n;
        }
        n.parent = y;
        update_augments_to_root(n);
        // Re-establish red-black tree invariants.
        while (n.parent != null && n.parent.color == Color.RED) {
            if (n.parent.isLeftChild()) {
                Node uncle = n.parent.parent.right;
                if (uncle != null && uncle.color == Color.RED) {
                    n.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    n = n.parent.parent;
                    n.color = Color.RED;
                } else {
                    if (n.isRightChild()) {
                        n = n.parent;
                        rotate_left(n);
                    }
                    n.parent.color = Color.BLACK;
                    n.parent.parent.color = Color.RED;
                    rotate_right(n.parent.parent);
                }
            } else if (n.parent.isRightChild()) {
                Node uncle = n.parent.parent.left;
                if (uncle != null && uncle.color == Color.RED) {
                    n.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    n = n.parent.parent;
                    n.color = Color.RED;
                } else {
                    if (n.isLeftChild()) {
                        n = n.parent;
                        rotate_right(n);
                    }
                    n.parent.color = Color.BLACK;
                    n.parent.parent.color = Color.RED;
                    rotate_left(n.parent.parent);
                }
            } else {
                throw new RuntimeException("Root is red.");
            }
        }
        root.color = Color.BLACK;
    }

    public void erase(int key) {
        // Find node with key to erase
        Node z = find(key);
        // Find node to detach.
        Node x, y;
        if (z.left == null || z.right == null) {
            y = z;
        } else {
            // Let y be the successor of z
            if (z.right != null) {
                // Return leftmost node in z.right
                y = z.right;
                while (y.left != null) y = y.left;
            } else {
                y = z.parent;
                while (y != null && y.right == z) { z = y; y = y.parent; }
            }
        }
        // Find y's only child.
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        // Detach y by updating parent and child pointers of y's parent and child
        Node x_parent = y.parent;
        if (x != null) x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y.isLeftChild()) {
            y.parent.left = x;
        } else {
            // y is right child.
            y.parent.right = x;
        }
        // If we were supposed to erase another node z,
        // then copy the actually-erased node's data into the node
        // we were supposed to erase.
        z.key = y.key;

        update_augments_to_root(x == null ? x_parent : x);
        if (y != z) update_augments_to_root(z);
        if (y.color == Color.RED) return;
        // We deleted a black node, so we need to fixup.
        while (x != root && (x == null || x.color == Color.BLACK)) {
            // Cannot use isLeftChild() here since x may be null.
            if (x_parent.left == x) {
                Node w = x_parent.right;
                if (w != null && w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x_parent.color = Color.RED;
                    rotate_left(x_parent);
                    w = x_parent.right;
                }
                if (w == null ||
                        ((w.left == null || w.left.color == Color.BLACK) &&
                            (w.right == null || w.right.color == Color.BLACK))) {
                    if (w != null) w.color = Color.RED;
                    x = x_parent;
                    x_parent = x.parent;
                } else {
                    if (w.right == null || w.right.color == Color.BLACK) {
                        if (w.left != null) w.left.color = Color.BLACK;
                        w.color = Color.RED;
                        rotate_right(w);
                        w = x_parent.right;
                    }
                    if (w != null) w.color = x_parent.color;
                    x_parent.color = Color.BLACK;
                    if (w.right != null) w.right.color = Color.BLACK;
                    rotate_left(x_parent);
                    x = root;
                }
            } else {
                Node w = x_parent.left;
                if (w != null && w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x_parent.color = Color.RED;
                    rotate_right(x_parent);
                    w = x_parent.left;
                }
                if (w == null ||
                        ((w.right == null || w.right.color == Color.BLACK) &&
                            (w.left == null || w.left.color == Color.BLACK))) {
                    if (w != null) w.color = Color.RED;
                    x = x_parent;
                    x_parent = x.parent;
                } else {
                    if (w.left == null || w.left.color == Color.BLACK) {
                        if (w.right != null) w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        rotate_left(w);
                        w = x_parent.left;
                    }
                    if (w != null) w.color = x_parent.color;
                    x_parent.color = Color.BLACK;
                    if (w.left != null) w.left.color = Color.BLACK;
                    rotate_right(x_parent);
                    x = root;
                }
            }
        }
        if (x != null) x.color = Color.BLACK;
    }

    private void rotate_left(Node n) {
        assert n.right != null : "Cannot rotate left, no right child.";

        if (n.isLeftChild()) {
            n.parent.left = n.right;
        } else if (n.isRightChild()) {
            n.parent.right = n.right;
        }

        Node t = n.right.left;
        n.right.left = n;
        n.right.parent = n.parent;
        n.parent = n.right;
        n.right = t;
        if (t != null) t.parent = n.right;
        update_augments_to_root(n);
        if (t != null) { t.parent = n; }
        if (n.parent.parent == null) { root = n.parent; }
    }

    private void rotate_right(Node n) {
        assert n.left != null : "Cannot rotate right, no left child.";

        if (n.isLeftChild()) {
            n.parent.left = n.left;
        } else if (n.isRightChild()) {
            n.parent.right = n.left;
        }

        Node t = n.left.right;
        n.left.right = n;
        n.left.parent = n.parent;
        n.parent = n.left;
        n.left = t;

        update_augments_to_root(n);
        if (t != null) { t.parent = n; }
        if (n.parent.parent == null) { root = n.parent; }
    }

    private void update_augments_to_root(Node n) {
       while (n != null) { n.update_augment(); n = n.parent; }
    }
}
