package trees.generaltrees.linkedlistarray;

public class Main {
    public static void main(String[] args) {
        TreeWithLinkedListOfChildren tree2 = new TreeWithLinkedListOfChildren();
        tree2.createTree();
        tree2.printPreorder();
        System.out.println();
        System.out.println(tree2.numNodes());
        System.out.println(tree2.numLevels());
        System.out.println(tree2.numLeaves());
        System.out.println(tree2.serialize());
    }
}
