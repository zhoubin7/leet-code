import java.util.*;
import java.util.stream.Collectors;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: TwoArraysJiaoji2
 * @Description: 两个数组的交集2
 * @Author: pug
 * @Date: 2020/7/13 11:12
 * @Version: 1.0
 */
public class TwoArraysJiaoji2 {

    public static void main(String[] args) {
        int num1[] = {4,9,5}, num2[] = {9,4,9,8,4};
        int[] intersect = intersect(num1, num2);
        System.out.println(intersect);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> res = new HashMap<>();
        for(int num :nums1){
            int count = res.getOrDefault(num,0)+1;
            res.put(num,count);
        }
        int[] intersection = new int[nums1.length];

        int index = 0;
        for (int num:nums2){
            int count = res.getOrDefault(num,0);
            if (count>0){
                intersection[index++] = num;
                count--;
                if (count>0){
                    res.put(num,count);
                }else {
                    res.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
