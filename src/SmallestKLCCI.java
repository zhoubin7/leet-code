import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: KsNum
 * @Description: 最小k个数
 * @Author: pug
 * @Date: 2021/3/19 09:56
 * @Version: 1.0
 */
public class SmallestKLCCI {

    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = i;
        }
//        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        long st = System.currentTimeMillis();
//        Arrays.sort(arr);
//        Arrays.stream(arr).limit(10).forEach(System.out::println);
        int[] ks = smallestK(arr, 10);
        Arrays.stream(ks).forEach(System.out::println);
        System.out.println(System.currentTimeMillis() - st + "ms");
    }

    public static int[] ks(int[] arr, int k) {
        //定义输出的结果数组
        int[] res = new int[k];

        if (arr.length == 0 || k == 0) {
            return res;
        }

        //定义优先队列，排序方式为升序
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);

        //先拿出k个数放入队列中
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }


        //循环比较数组中每一个元素与队顶的元素大小，peek取出队顶元素，队顶大，删之。并放入数组中的元素
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        //取出队列中k个数字
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public static int[] quickSearch(int[] arr, int low, int high, int target) {
        int j = partitionArray(arr, low, high);
        if (j == target) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j < target ? quickSearch(arr, j + 1, high, target) : quickSearch(arr, low, j - 1, target);
    }

    public static int partitionArray(int[] arr, int i, int j) {
        int target = arr[i];
        while (i < j) {
            while (j > i && arr[j] > target) j--;
            if (j > i) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < target) i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = target;
        return i;
    }
}
