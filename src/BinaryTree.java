/**
 * A class representing a binary tree data structure.
 *
 * @param <T> The type of data stored in the tree, must be comparable.
 */
public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root; // Make the root private

    /**
     * Creates a new BinaryTree instance with an empty root.
     */
    BinaryTree() {
        root = null;
    }

    /**
     * Sets the root of the binary tree.
     *
     * @param root The new root node.
     */
    public void setRoot(TreeNode<T> root) { // Add a method to set the root
        this.root = root;
    }

    /**
     * Gets the root of the binary tree.
     *
     * @return The root node.
     */
    public TreeNode<T> getRoot() { // Add a method to get the root
        return root;
    }

    /**
     * Inserts values into the binary tree.
     */
    public void treeInsert(BinaryTree t, TreeNode<T> z) {
        TreeNode<T> x = t.root;
        TreeNode<T> y = null;
        while (x != null) {
            y = x;
            if (z.val.compareTo(x.val) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            t.root = z;
        } else if (z.val.compareTo(y.val) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    /**
     * Deletes a node from the Binary Tree.
     *
     * @param t the tree from which the node will be deleted.
     * @param z the node to be deleted.
     */
    public void treeDelete(BinaryTree t, TreeNode<T> z) {
        System.out.println("To be deleted: "+z.val);
        if(z.left==null){
            transplant(t, z, z.right);
        } else if(z.right == null){
            transplant(t, z, z.left);
        } else{
            TreeNode <T> y = treeMinimum(z.right);
            if(y!=z.right){
                transplant(t, y, y.right);
                y.right=z.right;
                y.right.parent=y;
            }
            transplant(t,z,y);
            y.left=z.left;
            y.left.parent=y;
        }
    }


    /**
     * Replaces one subtree rooted at node 'u' with another subtree rooted at node 'v' in the binary tree.
     * The parent of node 'u' becomes the parent of node 'v' after the transplant.
     *
     * @param t The binary tree in which the transplant is performed.
     * @param u The node to be replaced.
     * @param v The node to replace 'u'.
     */
    public void transplant (BinaryTree t, TreeNode<T> u, TreeNode<T> v) {
        if(u.parent == null){
            t.root = v;
        } else if(u==u.parent.left){
            u.parent.left=v;
        }else{
            u.parent.right=v;
        }
        if(v!=null){
            v.parent=u.parent;
        }
    }

    /**
     * Performs an in-order traversal of the binary tree rooted at the given node.
     * Prints the value and maximum of each visited node, where the maximum is the max node value of the subtree.
     *
     * @param x The root node of the current subtree.
     */
    public void inOrderTreeWalk(TreeNode<T> x) {
        if (x != null) {
            inOrderTreeWalk(x.left);
            System.out.println("TreeNode Value: " + x.val + " Max: " + x.max);
            inOrderTreeWalk(x.right);
        }
    }

    /**
     * Finds the node with the minimum value in the binary tree rooted at the given node.
     *
     * @param x The root node of the current subtree.
     * @return The node with the minimum value in the subtree rooted at 'x'.
     */
    public TreeNode<T> treeMinimum(TreeNode<T> x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Recursively finds the maximum value in the binary tree rooted at the given node.
     * Considers both left and right child nodes.
     *
     * @param r The root node of the current subtree.
     * @return The maximum value in the subtree rooted at 'r'.
     */
    public T recMax(TreeNode<T> r) {
        if (r == null) {
            return null;
        } else if (r.left == null && r.right == null) {
            r.max = r.val;
        } else{
            T maxLeft = recMax(r.left);
            T maxRight = recMax(r.right);

            T maxChild = maxLeft != null && (maxRight == null || maxLeft.compareTo(maxRight) >= 0) ? maxLeft : maxRight;
            r.max = r.val.compareTo(maxChild) >= 0 ? r.val : maxChild;
        }
        return r.max;
    }

    /**
     * Finds the node with the maximum value in the binary tree rooted at the given node.
     *
     * @param x The root node of the current subtree.
     * @return The node with the maximum value in the subtree rooted at 'x'.
     */
    public TreeNode<T> treeMaximum(TreeNode<T> x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * Finds the successor node of the given node in the binary tree.
     * The successor is the node with the smallest value greater than the value of the given node.
     *
     * @param x The node for which to find the successor.
     * @return The successor node, or null if no successor is found.
     */
    public TreeNode<T> treeSuccessor(TreeNode<T> x) {
        if (x.right != null) {
            return treeMinimum(x.right);
        } else {
            TreeNode y = x.parent;
            while (y != null && x == y.right) {
                x = y;
                y = y.parent;
            }
            return y;
        }
    }

    /**
     * Recursively searches for a node with a specific value in the binary tree rooted at the given node.
     *
     * @param x The root node of the current subtree.
     * @param val The value to search for.
     * @return The node containing the specified value, or null if not found.
     */
    public TreeNode<T> treeSearch(TreeNode<T> x, T val) {
        if (x == null || val == x.val) {
            return x;
        }
        if (val.compareTo(x.val) < 0) {
            return treeSearch(x.left, val);
        } else {
            return treeSearch(x.right, val);
        }
    }

    /**
     * Iteratively searches for a node with a specific value in the binary tree rooted at the given node.
     *
     * @param x The root node of the current subtree.
     * @param val The value to search for.
     * @return The node containing the specified value, or null if not found.
     */
    public TreeNode<T> iterativeTreeSearch(TreeNode<T> x, T val) {
        while (x != null && val != x.val) {
            if (val.compareTo(x.val) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    /**
     * The main method to demonstrate the BinaryTree functionality.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        //Create a new Binary Tree
        BinaryTree<Integer> t;
        t = new BinaryTree<Integer>();


        //Create nodes
        TreeNode<Integer> a = new TreeNode<>(6);
        TreeNode<Integer> b = new TreeNode<>(2);
        TreeNode<Integer> c = new TreeNode<>(12);
        TreeNode<Integer> d = new TreeNode<>(3);
        TreeNode<Integer> e = new TreeNode<>(9);
        TreeNode<Integer> f = new TreeNode<>(1);
        TreeNode<Integer> g = new TreeNode<>(14);

        //Insert nodes to tree
        t.treeInsert(t, a);
        t.treeInsert(t, b);
        t.treeInsert(t, c);
        t.treeInsert(t, d);
        t.treeInsert(t, e);
        t.treeInsert(t, f);
        t.treeInsert(t, g);

        //Get the max value in each subtree
        Integer max = t.recMax(t.root);

        //Print the tree in order
        System.out.println ("In order tree walk:");
        t.inOrderTreeWalk(t.root);

        //Get the min value of the tree
        System.out.println("\nMin value: " + t.treeMinimum(t.root).val);

        //Get the max value of the tree
        System.out.println ("Max value:" + t.treeMaximum(t.root).val);

        //Get the successor of the tree root
        System.out.println ("Root successor:" + t.treeSuccessor(t.root).val);

        //Delete the root of the tree
        System.out.println("\nDELETE ROOT: "+t.root.val);
        t.treeDelete(t, t.root);
        System.out.println("NEW ROOT: "+t.root.val);


        //Perform an in order tree walk after deleting the root
        System.out.println ("\nIn order tree walk after deletion:");
        t.inOrderTreeWalk(t.getRoot());

        // Perform iterative tree search for specific values
        System.out.println("\nSearch the tree iteratively for values 9 and 7:");
        int searchValue1 = 9;
        int searchValue2 = 7;
        TreeNode<Integer> foundNode1 = t.iterativeTreeSearch(t.getRoot(), searchValue1);
        TreeNode<Integer> foundNode2 = t.iterativeTreeSearch(t.getRoot(), searchValue2);
        if (foundNode1 != null) {
            System.out.println("Node with value " + searchValue1 + " found: " + foundNode1.val);
        } else {
            System.out.println("Node with value " + searchValue1 + " not found.");
        }
        if (foundNode2 != null) {
            System.out.println("Node with value " + searchValue2 + " found: " + foundNode2.val);
        } else {
            System.out.println("Node with value " + searchValue2 + " not found.");
        }

        // Perform recursive tree search for specific values
        System.out.println("\nSearch the tree recursively for values 9 and 7:");
        TreeNode<Integer> foundNode3 = t.treeSearch(t.getRoot(), searchValue1);
        TreeNode<Integer> foundNode4 = t.treeSearch(t.getRoot(), searchValue2);
        if (foundNode3 != null) {
            System.out.println("Node with value " + searchValue1 + " found: " + foundNode1.val);
        } else {
            System.out.println("Node with value " + searchValue1 + " not found.");
        }
        if (foundNode4 != null) {
            System.out.println("Node with value " + searchValue2 + " found: " + foundNode2.val);
        } else {
            System.out.println("Node with value " + searchValue2 + " not found.");
        }
    }
}