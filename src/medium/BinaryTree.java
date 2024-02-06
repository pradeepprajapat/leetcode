package medium;

class Node {
    int v;
    Node left, right;

    Node(int v) {
        this.v = v;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    Node root = null;

    /**
     * this is Left, root, right
     * inOrder(root->left)
     * print(root->v)
     * inOrder(root->right)
     * non decreasing order print
     */

    private static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.v + ",");
        printInorder(node.right);
    }

    /*
     * root, left, right
     * print(root-> v)
     * preOrder(root->left)
     * preorder(root->right)
     * used in prefix expressions
     * used to copy tree
     * Time= O(n)
     * space = O(h) where h is height of tree
     * */
    private static void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.v + ",");
        printPreOrder(node.left);
        printPreOrder(node.right);

    }

    /*
     *Left, Right, root
     * postOrder(root->left)
     * postOrder(root->right)
     * print(root->v)
     * to delete tree
     * used in postfix expression of an expression tree
     * */
    private static void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.v + ",");
    }

    /**
     * maxDep(root->left), maxDep(root->right)
     * and then max of these 2 is maxHeight at that level
     */

    private static int getMaxDepthUsingDfs(Node node) {
        if (node == null) {
            return 0;
        }
        int ldepth = getMaxDepthUsingDfs(node.left);
        int rdepth = getMaxDepthUsingDfs(node.right);
        return Math.max(ldepth,rdepth)+1;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.right.left = new Node(6);
        bt.root.right.right = new Node(7);
        printInorder(bt.root);
        System.out.println();
        printPreOrder(bt.root);
        System.out.println();
        printPostOrder(bt.root);
        System.out.println();
        System.out.println(getMaxDepthUsingDfs(bt.root));
    }
}
