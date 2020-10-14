package Algorithm.greedy.simple;

import java.util.Arrays;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: LastStoneWeight
 * @Description: 1046. 最后一块石头的重量
 * @Author: pug
 * @Date: 2020/10/13 17:51
 * @Version: 1.0
 */
public class LastStoneWeight {
    public static void main(String[] args) {
//        [2,7,4,1,8,1]
        int[] stones = {2,7,4,1,8,1};
        int i = lastStoneWeight(stones);
        System.out.println(i);
    }
    public static int lastStoneWeight(int[] stones) {
        int index = stones.length - 1;
        for(int i = 0; i < stones.length - 1; i++){     //通过stones.length来判断需要操作的次数。（不用将stones.length == 1的情况单独考虑）
            Arrays.sort(stones);                        //将sort放在循环体的开始。（避免在循环体外再写一次重复的sort（））
            stones[index] -= stones[index-1];           //两种不同情况使用同一表达式处理。（）
            stones[index-1] = 0;
        }
        return stones[stones.length-1];
    }
}
