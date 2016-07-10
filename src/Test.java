/**
 * Created by neeluagrawal on 10-07-2016.
 */
public class Test {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);

        //Traversal related start......................................................................
        System.out.print("\nPreorder traversal: ");
        tree.printPreOrder(tree.root);

        System.out.print("\nPostorder traversal: ");
        tree.printPostOrder(tree.root);

        System.out.print("\nInorder traversal: ");
        tree.printInOrder(tree.root);

        System.out.print("\nLevelorder traversal: ");
        tree.printLevelOrder(tree.root);

        System.out.print("\nLevelorder traversal using Queue: ");
        tree.printLevelOrderQueue(tree.root);

        System.out.print("\nLevelorder traversal using 2 stack: ");
        tree.levelOrderTraversalSpiral(tree.root);

        System.out.print("\nBoundary print Clockwise: ");
        tree.printBoundary(tree.root);

        System.out.print("\nInOrder without recursion using Stack: ");
        tree.iterativeInOrder(tree.root);

        System.out.print("\nInOrder without recursion without Stack: ");
        tree.IterativeInOrderMorris(tree.root);

        System.out.print("\nIterative PreOrder using Stack: ");
        tree.IterativePreOrder(tree.root);

        System.out.print("\nInOrder traversal of tree constructed from inorder and preorder: ");
        int in[] = {4, 2, 5, 1, 6, 3};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int len = in.length;
        Node node = tree.treeFromInOrderPreOrder(in, pre, 0, len - 1);
        tree.printInOrder(node);

        //special tree because every node has value greater than its both child
        System.out.print("\nInorder traversal of tree constructed from inorder: ");
        int inorder[] = {5, 10, 40, 30, 28};
        len = inorder.length;
        node = tree.specialBtreeFromInOrder(inorder, 0, len - 1);
        tree.printInOrder(node);

        //Traversal related end......................................................................


        //general basic Start........................................................................
        System.out.print("\nheight: ");
        System.out.print(tree.height(tree.root));

        System.out.print("\ndiameter: ");
        System.out.print(tree.diameter(tree.root));

        System.out.print("\nsize: ");
        System.out.print(tree.size(tree.root));

        System.out.print("\nMax width: ");
        System.out.print(tree.maxWidth(tree.root));

        System.out.print("\nLeaf count: ");
        System.out.print(tree.leafCount(tree.root));

        System.out.print("\nLeaf Print right to left: ");
        tree.printLeafs(tree.root);

        System.out.print("\nIsHeightBalanced: ");
        System.out.print(tree.isHeightBalanced(tree.root));

        System.out.print("\nMirror tree: ");
        node = tree.mirrorTree(tree.root);
        tree.printInOrder(node);

        System.out.print("\nDouble tree: ");
        node = tree.doubleTree(tree.root);
        tree.printInOrder(node);

        System.out.print("\nIsFoldable: ");
        System.out.print(tree.isFoldable(tree.root));

        //general basic end........................................................................


        //two tree comparision start......................................................................

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(8);

        tree.root1 = new Node(1);
        tree.root1.left = new Node(3);
        tree.root1.right = new Node(2);
        tree.root1.right.left = new Node(4);
        tree.root1.right.right = new Node(5);
        tree.root1.left.right = new Node(6);
        tree.root1.right.right.left = new Node(8);
        tree.root1.right.right.right = new Node(7);

        System.out.print("\nIsIdentical: ");
        System.out.print(tree.isIdentical(tree.root, tree.root1));

        System.out.print("\nIsIsomorphic: ");
        System.out.print(tree.isIsomorphic(tree.root, tree.root1));


        //two tree comparision end......................................................................


    }
}
