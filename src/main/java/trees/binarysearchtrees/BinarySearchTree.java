package trees.binarysearchtrees;

class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        int data; // value at the node
        BSTNode left; // left child
        BSTNode right; // right child

        BSTNode(int newdata) {
            data = newdata;
        }
    } // end of class BSTNode

    private BSTNode root; // the root of the tree

    /**
     * Constructor
     */
    BinarySearchTree() {
        root = null;
    }

    /**
     * Find a given element in the tree.
     * @param elem element to search for
     * @return true if found the element, false otherwise
     */
    public boolean findIterative(int elem) {
        BSTNode current = root;
        while (current != null) {
            if (elem == current.data)
                return true;
            else if (elem < current.data)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }


    /**
     * The recursive implementation of the find method. Calls the private method.
     * @param elem element to search for
     * @return true if found the element, false otherwise
     */
    public boolean findRecursive(int elem) {
        return findRecursive(elem, this.root);
    }

    /**
     * The recursive implementation of the find method
     * @param elem element to search for
     * @param root root of the tree in which to search
     * @return true if found the element, false otherwise
     */
    private boolean findRecursive(int elem, BSTNode root) {
        if (root == null)
            return false;
        if (root.data == elem)
            return true;
        if (elem < root.data) {
            return findRecursive(elem, root.left);
        }
        else
            return findRecursive(elem, root.right);
    }

    /**
     * Insert an element in the BST (iterative)
     * @param elem value to insert
     */
    public void insertIterative(int elem) {
        BSTNode prev = null; // need to keep track of the node to which we will be attaching the new node
        BSTNode current = root;
        if (root == null) {
            root = new BSTNode(elem);
            return;
        }
        while (current != null) {
            if (elem >= current.data) {
                prev = current;
                current = current.right;
            }
            else {
                prev = current;
                current = current.left;
            }
        }
        if (elem < prev.data) {
            // create a new node and attach to prev
            prev.left = new BSTNode(elem);
        }
        else {
            // create a new node and attach to prev
            prev.right = new BSTNode(elem);
        }
    }


    /**
     * Recursive insert method - calls the private insert method.
     * @param elem element to insert
     */
    public void insertRecursive(int elem) {
        this.root  = insertRecursive(elem, this.root);
    }

    /**
     *
     * @param elem
     * @param root
     * @return
     */
    private BSTNode insertRecursive(int elem, BSTNode root) {
        if (root == null)
            return new BSTNode(elem);
        if (elem < root.data) {
            root.left = insertRecursive(elem, root.left);
        }
        else {
            root.right = insertRecursive(elem, root.right);
        }
        return root;
    }

    public void deleteIterative(int elem) {
        if (root == null) { // nothing to delete
            return;
        }
        BSTNode prev = null;
        BSTNode current = root;

        // Find current that contains the elem value
        // Keep track of prev (parent)
        while (current != null) {
            if (elem == current.data)
                break;
            else if (elem > current.data) {
                prev = current;
                current = current.right;
            }
            else {
                prev = current;
                current = current.left;
            }
        }
        //System.out.println(current.data);
        if (current == null)
            return; // element not in the tree, nothing to delete

        // Removing a node with one child
        // The root also needs to change if we delete the root
        if (current.left == null) { // no left child
            if (prev == null) {
                // removing the root with one right child
                root = root.right;
                return;
            }
            // Removing a node without the left child, but it is not a root
            if (prev.left == current)
                prev.left = current.right; // since current has not left child
            else { //current is the right child of prev
                prev.right = current.right;
            }
        }
        else if (current.right == null){ // removing a node that does not have the right child
            if (prev == null) {
                // removing the root with one left child
                root = root.left;
                return;
            }
            // Removing a node without the right child, but it is not a root
            if (prev.left == current)
                prev.left = current.left;
            else { //current is the right child of prev
                prev.right = current.left;
            }
        }
        else { // has both children
            // Find the smallest value in the right subtree
            BSTNode rightRoot = current.right;
            BSTNode prevBeforeRightRoot = current;
            while (rightRoot.left != null ) {
                prevBeforeRightRoot = rightRoot;
                rightRoot = rightRoot.left;
            }
            System.out.println("smallest in the right subtree " + rightRoot.data);

            int smallest = rightRoot.data;
            current.data = smallest;
            // Remove smallest
            if (prevBeforeRightRoot.right == rightRoot) {
                prevBeforeRightRoot.right  = rightRoot.right;
            }
            else
                prevBeforeRightRoot.left = rightRoot.right;
        }
    }

    /** Print a binary tree (preorder) */
    public void printPreorder() {
        printPreorder(root);
    }


    private void printPreorder(BSTNode root) {
        if (root != null) {
            System.out.print(" " + root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(6);
        tree.insertIterative(1);
        tree.insertIterative(10);
        tree.insertIterative(8);
        tree.insertIterative(12);
        tree.insertIterative(16);
        tree.printPreorder();
        System.out.println();
        System.out.println(tree.findIterative(12));
        System.out.println(tree.findIterative(13));
        tree.deleteIterative(12);
        System.out.println(tree.findIterative(12));
        tree.printPreorder();
        System.out.println();
    }
}
