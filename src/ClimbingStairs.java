/**
 * @Package: PACKAGE_NAME
 * @ClassName: ClimbingStairs
 * @Description: 爬楼梯
 * @Author: pug
 * @Date: 2020/9/4 16:51
 * @Version: 1.0
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(Integer.MAX_VALUE / 2));
        System.out.println(climbStairs1(Integer.MAX_VALUE / 2));
        System.out.println(climbStairs2(Integer.MAX_VALUE / 2));
    }
    public static long climbStairs(int n) {
        long p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
    public static long climbStairs1(int n) {
        long[][] q = {{1, 1}, {1, 0}};
        long[][] res = pow(q, n);
        return res[0][0];
    }
    public static long[][] pow(long[][] a, int n) {
        long[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    public static int climbStairs2(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int)(fibn / sqrt5);
    }

}
