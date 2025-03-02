package trees.binarytrees;

import queues.ArrayQueue;
import queues.Queue;

public class BinaryTree {

    /** An inner class representing a node in a binary tree */
    private class BinaryTreeNode {
        int data; // value stored at the node
        BinaryTreeNode left; // left subtree
        BinaryTreeNode right; // right subtree

        BinaryTreeNode(int newData) {
            data = newData;
        }
    } // end of class BinaryTreeNode

    private BinaryTreeNode root; // the root of the tree

    public BinaryTree() {
        root = null; // initially, the tree is empty
    }

    /** Print a binary tree (preorder) */
    public void printPreorder() {
        printPreorder(root);
    }


    /** Print a binary tree (inorder) */
    public void printInorder() {
        printInorder(root);
    }

    /** Print a binary tree (preorder) */
    public void printPostorder() {
        printPostorder(root);
    }

    /** Return the number of levels of the tree */
    public int numLevels() {return numLevels(root); }

    /** Return the number of leaves of the tree */
    public int numLeaves() {return numLeaves(root); }

    /** Return the number of nodes in the tree */
    public int numNodes() {
        return numNodes(root);
    }

    /**
     * Print nodes of the binary tree using preorder traversal
     */
    private void printPreorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    /**
     * Print nodes of the binary tree using inorder traversal
     */
    private void printInorder(BinaryTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    /**
     * Print nodes of the binary tree using postorder traversal
     */
    private void printPostorder(BinaryTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
    }


    /**
     * Returns the number of levels in the tree
     * @param root root of the binary tree
     * @return number of levels
     */
    private int numLevels(BinaryTreeNode root) {
        // return the number of levels of the tree
        if (root == null)
            return 0;
        return 1 + Math.max(numLevels(root.left), numLevels(root.right));
    }

    /** Return the number of leaves of the tree */
    private int numLeaves(BinaryTreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return numLeaves(root.left) + numLeaves(root.right);
    }

    /**
     * Return the number of nodes of the tree
     * @param root root of the tree
     * @return number of nodes
     */
    private int numNodes(BinaryTreeNode root) {
        if (root == null)
            return 0;
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    /**
     * Traverse the tree level by level top to bottom, left to right,
     * and print all the node values.
     * Example:
                     5
           2                    10
     18      29             35      3
        1                 6            5
      9

     Traversing the tree by level will print:
     5, 2, 10, 18, 29, 35, 3, 1, 6, 5, 9
     */
    public void printByLevel() {
        BinaryTreeNode curr = root;
        Queue queue = new ArrayQueue(100);
        queue.enqueue(curr);
        while (!queue.empty()) {
            BinaryTreeNode node = (BinaryTreeNode) queue.dequeue();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }

    }

    public void createSampleTree() {
        // Note: this is not a binary search tree, just a binary tree
        root = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(35);
        BinaryTreeNode node4 = new BinaryTreeNode(3);
        BinaryTreeNode node5 = new BinaryTreeNode(18);
        BinaryTreeNode node6 = new BinaryTreeNode(29);
        BinaryTreeNode node7 = new BinaryTreeNode(6);
        BinaryTreeNode node8 = new BinaryTreeNode(5);
        BinaryTreeNode node9 = new BinaryTreeNode(1);
        BinaryTreeNode node10 = new BinaryTreeNode(9);

        root.right =  node1;
        root.left = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
        node4.right = node8;
        node5.right = node9;
        node9.left = node10;
    }
}
