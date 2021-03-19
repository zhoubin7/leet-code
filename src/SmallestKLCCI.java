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
        long st = System.currentTimeMillis();
//        Arrays.sort(arr);
//        Arrays.stream(arr).limit(10).forEach(System.out::println);
        ks(arr, 10);
        System.out.println(System.currentTimeMillis() - st+"ms");
    }

    public static void ks(int[] arr, int k){
        //定义输出的结果数组
        int[]res = new int[k];

        //定义优先队列，排序方式为升序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 -o2;
            }
        });

        //先拿出k个数放入队列中
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }


        //循环比较数组中每一个元素与队顶的元素大小，peek取出队顶元素，队顶大，删之。并放入数组中的元素
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        //取出队列中k个数字
        for (int i = 0; i < k; ++i) {
            res[i] = queue.poll();
        }

        Arrays.stream(res).forEach(System.out::println);
    }
}
