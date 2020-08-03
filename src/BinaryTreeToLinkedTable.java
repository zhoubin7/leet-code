
/**
 * @Package: PACKAGE_NAME
 * @ClassName: BinaryTreeToLinkedTable
 * @Description: 给定一个二叉树，原地将它展开为一个单链表。
 * @Author: pug
 * @Date: 2020/8/3 10:58
 * @Version: 1.0
 */
public class BinaryTreeToLinkedTable {

    public static void main(String[] args) {
        TreeNode right6 = new TreeNode(6,null,null);
        TreeNode right5 = new TreeNode(5,null,right6);
        TreeNode left3 = new TreeNode(3,null,null);
        TreeNode right4 = new TreeNode(4,null,null);
        TreeNode left2 = new TreeNode(2,left3,right4);
        TreeNode root = new TreeNode(1,left2,right5);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        // 将左子树展开为单链表
        flatten(root.left);
        // 将右子树展开为单链表
        flatten(root.right);
        // 暂存右子树
        TreeNode temp = root.right;
        // 左子树接到根的右侧
        root.right = root.left;
        // 左子树置空
        root.left = null;
        // 再接上右子树
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
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
