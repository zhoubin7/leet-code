import java.util.HashMap;
import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: SingleNumberIII
 * @Description: 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * @Author: pug
 * @Date: 2020/9/1 17:08
 * @Version: 1.0
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        int[]nums = {1,2,1,3,2,5};
        for (int i : singleNumber2(nums)) {
            System.out.println(i);
        }
    }

    /**
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)，哈希表所使用的空间。
     */
    public static int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] op = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)
                op[idx++] = entry.getKey();
        }
        return op;
    }
    /**
     * 时间复杂度：O(N)。的时间遍历输入数组。
     * 空间复杂度：O(1)
     */
    public static int[] singleNumber1(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) {
            if ((num&diff)!=0)
                x^=num;
        }
        return new int[]{x,bitmask^x};
    }

    public static int[] singleNumber2(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff = Integer.highestOneBit(diff);
        int[] result = { 0, 0 };
        for (int n : nums) {
            //当前位是 0 的组, 然后组内异或
            if ((diff & n) == 0) {
                result[0] ^= n;
                //当前位是 1 的组
            } else {
                result[1] ^= n;
            }
        }
        return result;
    }

}