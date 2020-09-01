import java.util.*;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: SingleNumberII
 * @Description: 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * @Author: pug
 * @Date: 2020/9/1 11:26
 * @Version: 1.0
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[]nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
        System.out.println(singleNumber3(nums));
    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for (int k : map.keySet())
            if (map.get(k) == 1) return k;
        return -1;
    }

    /**
     *~(A) = -(A+1)
     *
     */
    public static int singleNumber1(int[] nums) {
        int one=0,two=0;
        for(int num:nums){
            one = one^num & ~two;
            two = two^num & ~one;
        }
        return one;
    }

    public int singleNumber11(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            one = ~two & (one ^ num);
            two = ~one & (two ^ num);
        }
        return two;
    }

    public static int singleNumber2(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }

    public static int singleNumber3(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1) return k;
        return -1;
    }
}
