package binaryTree;

public class TreeApp {
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.insert(3, 1.5);
        theTree.insert(4, 1.7);
        theTree.insert(5, 1.9);

        node found = theTree.find(4);
        if (found != null) {
            System.out.println("found node 4");
        }else{
            System.out.println("node 4 not found");
        }
    }
}
