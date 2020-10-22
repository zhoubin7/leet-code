package Algorithm.greedy.mid;

/**
 * @Package: Algorithm.greedy.mid
 * @ClassName: JumpGame
 * @Description: 55. 跳跃游戏
 * @Author: pug
 * @Date: 2020/10/22 10:40
 * @Version: 1.0
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == 0)) {
            return true;
        }
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
        }
        if (nums[0] >= distance) {
            return true;
        } else {
            return false;
        }
    }
}
