package Algorithm.greedy.simple;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: MaximizeSumOfArrayAfterKNegations
 * @Description: 1005. K 次取反后最大化的数组和
 * @Author: pug
 * @Date: 2020/10/13 17:21
 * @Version: 1.0
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
//        A = [4,2,3], K = 1
        int[] a = {4,2,3};
        int k =1;
        int i = largestSumAfterKNegations(a, k);
        System.out.println(i);
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
        int[] number = new int[201];//-100 <= A[i] <= 100,这个范围的大小是201
        for (int t : A) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (K > 0) {
            while (number[i] == 0)//找到A[]中最小的数字
                i++;
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            if (i > 100) {//若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
                i = 200 - i;
            }
            K--;
        }
        int sum = 0;
        for (int j = i; j <number.length ; j++) {//遍历number[]求和
            sum += (j-100)*number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;
    }

}
