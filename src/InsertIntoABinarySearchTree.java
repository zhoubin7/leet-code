/**
 * @Package: PACKAGE_NAME
 * @ClassName: InsertIntoABinarySearchTree
 * @Description: 二叉搜索树中的插入操作
 * @Author: pug
 * @Date: 2020/9/30 10:58
 * @Version: 1.0
 */
public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode root = new TreeNode(4, n2, n7);
        TreeNode treeNode = insertIntoBST1(root, 5);
        System.out.println(treeNode.toString());
    }

    /**
     * 递归
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 迭代
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
