package trees.binarytrees;

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createSampleTree();
        tree.printPreorder();
        System.out.println();
        tree.printInorder();
        System.out.println();
        tree.printPostorder();
        System.out.println();
        System.out.println(tree.numNodes());
        System.out.println(tree.numLevels());
        System.out.println(tree.numLeaves());
        tree.printByLevel();
    }
}
