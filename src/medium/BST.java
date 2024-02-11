package medium;

class BtNode {
    int val;
    BtNode left;
    BtNode right;

    BtNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BST {
    BtNode root;

    BST() {
        root = null;
    }

    private void insert(int k) {
        root = add(root, k);
    }

    private BtNode add(BtNode root, int v) {
        BtNode node = new BtNode(v);

        if (root == null) {
            root = node;
        } else if (v < root.val) {
            root.left = add(root.left, v);
        } else {
            root.right = add(root.right, v);
        }
        return root;
    }

    private void printInorder(BtNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    private void inOrder() {
        printInorder(root);
    }

    private void delete(int v) {
        root = deleteBtNode(root, v);
    }

    private BtNode deleteBtNode(BtNode root, int v) {
        if (root == null) {
            return root;
        }
        if (v < root.val) {
            root.left = deleteBtNode(root.left, v);
        } else if (v > root.val) {
            root.right = deleteBtNode(root.right, v);
        } else {
            if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                //find either inorder predecsssor of left subtree ( max val of left subtree)
                // or inorder successor of right subtree ( min value of right subtree)
                BtNode c = root.right;
                while (c.left != null) {
                    c = c.left;
                }
                root.val = c.val;
                root.right = deleteBtNode(root.right, c.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BST bt = new BST();
        bt.insert(10);
        bt.insert(20);
        bt.insert(30);
        bt.insert(5);
        bt.insert(0);
        bt.insert(15);
        bt.inOrder();
        bt.delete(15);
        bt.inOrder();
    }
}
