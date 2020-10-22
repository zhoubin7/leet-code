package Algorithm.greedy.mid;

/**
 * @Package: Algorithm.greedy.mid
 * @ClassName: GasStation
 * @Description: 134. 加油站
 * @Author: pug
 * @Date: 2020/10/22 11:12
 * @Version: 1.0
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tt = 0;
        int ct = 0;
        int ss = 0;
        for (int i = 0; i < n; ++i) {
            int tmp = gas[i] - cost[i];
            tt += tmp;
            ct += tmp;
            if (ct < 0) {
                ss = i + 1;
                ct = 0;
            }
        }
        return tt >= 0 ? ss : -1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0, j = 0; i < n; i += j + 1) {
            int cur = 0;
            for (j = 0; j < n; j++) {
                int k = (i + j) % n;
                cur += gas[k] - cost[k];
                if (cur < 0) break;
            }
            if (j >= n) return i;
        }
        return -1;
    }
}
