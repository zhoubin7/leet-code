/**
 * @Package: PACKAGE_NAME
 * @ClassName: MagicIndex
 * @Description: 魔术索引
 * @Author: pug
 * @Date: 2020/7/31 11:28
 * @Version: 1.0
 */
public class MagicIndex {

    public static void main(String[] args) {
        int nums[] = {8,9,10,11,12,13};
        System.out.println(findMagicIndex(nums));
    }

    public static int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public static int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
}
