import java.util.*;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: lottery
 * @Description: 彩票
 * @Author: pug
 * @Date: 2020/8/4 12:58
 * @Version: 1.0
 */
public class lottery {
    public static void main(String[] args) {
        Set<Integer> reds = new TreeSet<>();
        Set<Integer> bules = new TreeSet<>();
        for (; ; ) {
            if (reds.size() ==5){
                break;
            }
            int red = randomRed();
            if (red == 0) {
                continue;
            }
            reds.add(red);
        }
        for (; ; ) {
            if (bules.size() ==2){
                break;
            }
            int blue = randomBlue();
            if (blue == 0) {
                continue;
            }
            bules.add(blue);
        }
        System.out.println(reds+" | "+bules);
    }

    private static int randomRed() {
        return new Random().nextInt(35);
    }

    private static int randomBlue() {
        return new Random().nextInt(12);
    }
}
