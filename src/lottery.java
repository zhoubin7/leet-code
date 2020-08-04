import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
        int r1 = new Random().nextInt(35);
        int r2 = new Random().nextInt(35);
        int r3 = new Random().nextInt(35);
        int r4 = new Random().nextInt(35);
        int r5 = new Random().nextInt(35);
        List<Integer> redToday = new ArrayList<>();
        redToday.add(r1);
        redToday.add(r2);
        redToday.add(r3);
        redToday.add(r4);
        redToday.add(r5);
        Collections.sort(redToday);

        int b1 = new Random().nextInt(12);
        int b2 = new Random().nextInt(12);
        List<Integer> blueToday = new ArrayList<>();
        blueToday.add(b1);
        blueToday.add(b2);
        Collections.sort(blueToday);
        System.out.println(redToday+" | "+blueToday);
    }
}
