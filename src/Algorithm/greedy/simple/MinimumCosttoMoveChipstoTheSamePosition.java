package Algorithm.greedy.simple;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: MinimumCosttoMoveChipstoTheSamePosition
 * @Description: 1217. 玩筹码
 * @Author: pug
 * @Date: 2020/10/14 11:35
 * @Version: 1.0
 */
public class MinimumCosttoMoveChipstoTheSamePosition {
    public static void main(String[] args) {
//        chips = [1,2,3]
        int[] position = {1,2,3};
        int i = minCostToMoveChips(position);
        System.out.println(i);
    }
    public static int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else if (position[i] % 2 != 0) {
                odd++;
            }
        }
        return Math.min(even, odd);
    }

}
