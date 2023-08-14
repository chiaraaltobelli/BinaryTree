/**
 * A class representing a node in a binary tree. Each node contains a value of a comparable type,
 * references to its left and right child nodes, a reference to its parent node,
 * and an associated maximum value within its subtree.
 *
 * @param <T> The type of data stored in the node, must be comparable.
 */
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;
    T max;

    /**
     * Creates a new TreeNode instance with a specified value.
     * Sets the left, right, parent, and max of the TreeNode to null.
     *
     * @param val the value of the TreeNode.
     */
    TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null; // Initialize parent as null
        this.max = null;
    }

    /**
     * Compares the value of a TreeNode to the value of another TreeNode.
     *
     * @param otherNode the object to be compared.
     * @return
     */
    @Override
    public int compareTo(TreeNode<T> otherNode) {
        return this.val.compareTo(otherNode.val);
    }
}