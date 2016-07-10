import java.util.*;

/**
 * Created by neeluagrawal on 10-07-2016.
 */

public class BinaryTree {
    Node root;

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public void printPostOrder(Node node) {
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void printPreOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void printInOrder(Node node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public void printLevelOrder(Node node) {
        int h = height(node);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i);
        }
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        if (lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
    }

    public void printGivenLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }


    public void printLevelOrderQueue(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public void levelOrderTraversalSpiral(Node node) {
        if (node == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }

            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }


    public void printBoundary(Node node) {
        //Clockwise
        if (node != null) {
            System.out.print(node.data + " ");
            printBoundaryRight(node.right);
            printLeafs(node.right);
            printLeafs(node.left);
            printBoundaryLeft(node.left);
        }
    }

    private void printBoundaryLeft(Node node) {
        if (node != null) {
            if (node.left != null) {
                printBoundaryLeft(node.left);
                System.out.print(node.data + " ");
            } else if (node.right != null) {
                printBoundaryLeft(node.right);
                System.out.print(node.data + " ");
            }
        }
    }

    private void printLeafs(Node node) {
        if (node != null) {
            printLeafs(node.right);
            if (node.left == null && node.right == null)
                System.out.print(node.data + " ");
            printLeafs(node.left);
        }
    }

    private void printBoundaryRight(Node node) {
        if (node != null) {
            if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryRight(node.right);
            } else if (node.left != null) {
                System.out.print(node.data + " ");
                printBoundaryRight(node.left);
            }
        }
    }

    public void iterativeInOrder(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public void IterativeInOrderMorris(Node node) {
        Node current, pre;
        if (node == null)
            return;

        current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                //inorder predecessor of current node
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public void IterativePreOrder(Node node) {
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data+" ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }


}
