/**
 * Created by neeluagrawal on 10-07-2016.
 */
public class Test {

    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);

        System.out.println("\nPreorder traversal");
        tree.printPreOrder(tree.root);

        System.out.println("\nPostorder traversal");
        tree.printPostOrder(tree.root);

        System.out.println("\nInorder traversal");
        tree.printInOrder(tree.root);

        System.out.println("\nLevelorder traversal");
        tree.printLevelOrder(tree.root);

        System.out.println("\nLevelorder traversal using Queue");
        tree.printLevelOrderQueue(tree.root);

        System.out.println("\nLevelorder traversal using 2 stack");
        tree.levelOrderTraversalSpiral(tree.root);

        System.out.println("\nBoundary print Clockwise");
        tree.printBoundary(tree.root);

        System.out.println("\nInOrder without recursion using Stack");
        tree.iterativeInOrder(tree.root);

        System.out.println("\nInOrder without recursion without Stack");
        tree.IterativeInOrderMorris(tree.root);

        System.out.println("\nIterative PreOrder using Stack");
        tree.IterativePreOrder(tree.root);






    }
}
