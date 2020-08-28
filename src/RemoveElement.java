
/**
 * @Package: PACKAGE_NAME
 * @ClassName: RemoveElement
 * @Description: 移除元素
 * @Author: pug
 * @Date: 2020/8/28 14:13
 * @Version: 1.0
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[]nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int[]nums1 = {0,1,2,2,3,0,4,2};
        int val1 = 0;
        int len = removeElement(nums, val);
        int len1 = removeElement(nums1, val1);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(len1);
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i]);
        }
    }

    /**
     * 双指针：i,j
     * 循环遍历：
     *      j:正常循环走
     *      i:非移除元素时走
     *
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 双指针：i,j
     *      循环遍历：
     *          i:数组最左端
     *          j:数组最末端
     *      如果相等，则把数组末端的值赋值到i处
     *      j--:数组长度减1,i:再次判断时判断的是末端值是否是要移除的值，是则再把末端值赋值过来，否则代表不相等，则i++
     */
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i<j){
            if (nums[i]==val){
                nums[i] = nums[j-1];
                j--;
            }else {
                i++;
            }
        }
        return j;
    }

}
