// Version: 2017103101
public class Node {
    public int key;
    public Node left;
    public Node right;
    public Node parent;
    public Color color;
    public Augment augment;

    public boolean isRightChild() {
        return this.parent != null && this.parent.right == this;
    }

    public boolean isLeftChild() {
        return this.parent != null && this.parent.left == this;
    }

    public Node(int key) { this.key = key; this.color = Color.RED; update_augment(); }

    public void update_augment() {
        this.augment = Augment.combine(getLeftAugment(), getRightAugment(), key);
    }

    public Augment getLeftAugment() {
        return left == null ? Augment.leaf() : left.augment;
    }

    public Augment getRightAugment() {
        return right == null ? Augment.leaf() : right.augment;
    }
}
