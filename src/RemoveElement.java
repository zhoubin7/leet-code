
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
