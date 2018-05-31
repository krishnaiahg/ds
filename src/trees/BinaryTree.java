package trees;

public class BinaryTree {

    Node root;

    BinaryTree(Node root) {
        this.root = root;
    }

    public void preOrder() {

    }

    public void inOrder() {

    }

    public void postOrder() {

    }

    public void preOrder(Node root) {
        if (root.value == 0) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root.value == 0) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root.value == 0) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public void printTopview() {

    }

    public void printLeftView() {

    }

    public void printRightView() {

    }

    public int height() {
        return height(root);
    }

    protected int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int maxPath() {
        return maxPath(root);
    }

    protected int maxPath(Node root) {

        if (root == null) {
            return 0;
        }

        return root.value + Math.max(maxPath(root.left), maxPath(root.right));
    }

    protected Node toBinaryTree(int[] a, int start, int end) {
        if (a == null || start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        Node node = new Node(a[mid]);

        node.left = toBinaryTree(a, start, mid - 1);
        node.right = toBinaryTree(a, mid + 1, end);

        return node;
    }

    /*
     * Given a binary tree and a number K, the task is to find sum of tree nodes at
     * level k. The Binary Tree s given in string form:
     * (node-value(left-subtree)(right-subtree)).
     * 
     * Input: The first line of input contains an integer T denoting the no of test
     * cases. Then T test cases follow. Each test case contains an integer K
     * denoting level of Binary Tree for which we need sum. Next line is string
     * which represents Binary Tree.
     * 
     * Output: Print the Sum of all the elements at k level in each line.
     * 
     * Constraints: 1<=T<=100 1<=K<=20
     * 
     * Example: Input: 1 2 (0(5(6()())(4()(9()())))(7(1()())(3()()))) Output: 14
     * Explaination: The Tree from the above String will formed as:
     * 
     * 0 / \ 5 7 / \ / \ 6 4 1 3 \ 9
     */

    /*
     * Solution: input (0(5(6()())(4()(9()())))(7(1()())(3()()))) this is in
     * pre-order
     * 
     * so the numbers will be 0 5 6 4 9 7 1 3
     * 
     * roots children will be 2n+1 and 2n+2
     * 
     */

    public static void printSumAtLevel(int level, String input) {

        if (input == null || input.trim().length() == 0) {
            System.out.println("Invalid input");
        }
        char[] chars = input.toCharArray();

        int sumAtLevel = 0;
        int currentLevel = 0;

        for (char ch : chars) { // ?? can we terminate early??
            if (ch != '(' && ch != ')') {
                if (currentLevel == level) { // desired level
                    sumAtLevel += Character.getNumericValue(ch); // add to total
                }
            } else if (ch == '(') { // level up
                currentLevel++;
            } else if (ch == ')') { // level down
                currentLevel--;
            } else {

            }
        }
        System.out.println(sumAtLevel);

    }

    public static void main(String[] args) {
        int level = 2;
        String input = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        printSumAtLevel(level, input);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }
}