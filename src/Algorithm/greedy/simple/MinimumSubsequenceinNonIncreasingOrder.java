package Algorithm.greedy.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: MinimumSubsequenceinNonIncreasingOrder
 * @Description: 1403. 非递增顺序的最小子序列
 * @Author: pug
 * @Date: 2020/10/14 11:49
 * @Version: 1.0
 */
public class MinimumSubsequenceinNonIncreasingOrder {
    public static void main(String[] args) {
//        4,3,10,9,8
        int[] nums = {4, 3, 10, 9, 8};
        List<Integer> integers = minSubsequence1(nums);
        System.out.println(integers);
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int total = 0;
        for (int s : nums) {
            total += s;
        }
        Arrays.sort(nums);
        int temp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            temp += nums[i];
            list.add(nums[i]);
            if (2 * temp > total) {
                break;
            }

        }
        return list;
    }

    public static List<Integer> minSubsequence1(int[] nums) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int[] temp = new int[101];
        for (int num : nums) {
            temp[num]++;
            count += num;
        }
        int result = 0;
        a:
        for (int i = temp.length - 1; i >= 0; i--) {
            for (int j = 0; j < temp[i]; j++) {
                if (result <= count) {
                    list.add(i);
                }
                result += i;
                count -= i;
                if (result > count)
                    break a;
            }
        }
        return list;
    }
}
