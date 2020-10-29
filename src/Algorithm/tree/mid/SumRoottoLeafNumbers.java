package Algorithm.tree.mid;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Package: Algorithm.tree.mid
 * @ClassName: SumRoottoLeafNumbers
 * @Description: 129. 求根到叶子节点数字之和
 * @Author: pug
 * @Date: 2020/10/29 15:59
 * @Version: 1.0
 */
public class SumRoottoLeafNumbers {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        int i = sumNumbers1(t1);
        System.out.println(i);
    }

    /**
     * 广度优先搜索
     * 复杂度分析
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     *
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于队列，每个队列中的元素个数不会超过 n。
     *
     */
    public static int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

    /**
     * 深度优先搜索
     * 复杂度分析
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     *
     * 空间复杂度：O(n)，其中 n 是二叉树的节点个数。空间复杂度主要取决于递归调用的栈空间，
     * 递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)。
     *
     */
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public static int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
