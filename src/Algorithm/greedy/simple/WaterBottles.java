package Algorithm.greedy.simple;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: WaterBottles
 * @Description: 1518. 换酒问题
 * @Author: pug
 * @Date: 2020/10/21 14:49
 * @Version: 1.0
 */
public class WaterBottles {
    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        int i = numWaterBottles1(numBottles, numExchange);
        System.out.println(i);
    }
    public static int numWaterBottles(int j, int k) {
        int jp = j, hj = j;
        while (jp >= k) {
            jp -= k;
            ++hj;
            ++jp;
        }
        return hj;
    }
    public static int numWaterBottles1(int j, int k) {
        return j >= k ? (j - k) / (k - 1) + 1 + j : j;
    }

    public static int numWaterBottles2(int numBottles, int numExchange) {
        return (numBottles * numExchange - 1) / (numExchange - 1);
    }

    public static int numWaterBottles3(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles >= numExchange) {
            int change = numBottles / numExchange;
            total += change;
            numBottles = change + numBottles % numExchange;
        }
        return total;
    }
}
