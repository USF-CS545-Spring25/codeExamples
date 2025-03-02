package trees.generaltrees.childrenarray;

public class Main {

    public static void main(String[] args) {
        TreeWithArrayChildren t = new TreeWithArrayChildren();
        t.createTree();
        t.printNodesPreorder();
        System.out.println();
        System.out.println(t.numLevels());
        System.out.println(t.numNodes());
        System.out.println(t.numLeaves());
        System.out.println(t.serialize());
    }
}
