import java.util.*;

/**
 * Created by neeluagrawal on 10-07-2016.
 */

public class BinaryTree {
    Node root;

    //only used when using 2 tree comparision
    Node root1;


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

    public void printLeafs(Node node) {
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
            System.out.print(node.data + " ");
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }


    static int preIndex = 0;

    public Node treeFromInOrderPreOrder(int in[], int pre[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        Node node = new Node(pre[preIndex++]);
        if (inStart == inEnd)
            return node;

        int inIndex = search(in, inStart, inEnd, node.data);
        node.left = treeFromInOrderPreOrder(in, pre, inStart, inIndex - 1);
        node.right = treeFromInOrderPreOrder(in, pre, inIndex + 1, inEnd);
        return node;
    }

    private int search(int[] in, int inStart, int inEnd, int data) {
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == data)
                return i;
        }
        return i;
    }

    public Node specialBtreeFromInOrder(int in[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        int maxIndex = findMaxIndex(in, inStart, inEnd);
        Node node = new Node(in[maxIndex]);
        if (inStart == inEnd)
            return node;
        node.left = specialBtreeFromInOrder(in, inStart, maxIndex - 1);
        node.right = specialBtreeFromInOrder(in, maxIndex + 1, inEnd);
        return node;
    }

    private int findMaxIndex(int[] arr, int start, int end) {
        int i, maxInd = start, max = arr[start];
        for (i = start + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxInd = i;
            }
        }
        return maxInd;
    }


    public int diameter(Node node) {
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        int ldia = diameter(node.left);
        int rdia = diameter(node.right);
        return Math.max((1 + lheight + rheight), Math.max(ldia, rdia));
    }

    public int size(Node node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int maxWidth(Node node) {
        int height = height(node);
        int count[] = new int[height];
        maxWidthUtil(node, count, 0);
        int maxInd = findMaxIndex(count, 0, height - 1);
        return count[maxInd];
    }

    private void maxWidthUtil(Node node, int[] count, int level) {
        if (node != null) {
            count[level]++;
            maxWidthUtil(node.left, count, level + 1);
            maxWidthUtil(node.right, count, level + 1);
        }
    }

    public int leafCount(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return leafCount(node.left) + leafCount(node.right);
    }

    public boolean isHeightBalanced(Node node) {
        if (node == null)
            return true;
        int lheight = height(node.left);
        int rheight = height(node.right);
        int diff = Math.abs(lheight - rheight);

        if (diff <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right))
            return true;
        return false;
    }

    public Node mirrorTree(Node node) {
        if (node == null)
            return null;
        node.left = mirrorTree(node.left);
        node.right = mirrorTree(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return node;
    }

    public Node doubleTree(Node node) {
        return null;
    }

    public boolean isFoldable(Node node) {
        boolean res;
        if (node == null)
            return true;
        mirrorTree(node.left);
        res = isSameStruct(node.left, node.right);
        mirrorTree(node.left);
        return res;
    }

    private boolean isSameStruct(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return (isSameStruct(a.left, b.left) && isSameStruct(a.right, b.right));
    }

    public boolean isIdentical(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        return (a.data == b.data && isIdentical(a.left, b.left) && isIdentical(a.right, b.right));
    }

    public boolean isIsomorphic(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.data != b.data)
            return false;
        return (isIsomorphic(a.left, b.left) && isIsomorphic(a.right, b.right)) || (isIsomorphic(a.left, b.right) && isIsomorphic(a.right, b.left));
    }
}
