/**
 * @Package: PACKAGE_NAME
 * @ClassName: SqrtX
 * @Description: x 的平方根
 * @Author: pug
 * @Date: 2020/9/4 14:46
 * @Version: 1.0
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(5));
        System.out.println(mySqrt1(51));
        System.out.println(mySqrt2(53));
    }

    /**
     * 袖珍计算器算法
     * 「袖珍计算器算法」是一种用指数函数 \expexp 和对数函数 \lnln 代替平方根函数的方法。我们通过有限的可以使用的数学函数，得到我们想要计算的结果。
     *
     * 时间复杂度：O(1)，由于内置的 exp 函数与 log 函数一般都很快，我们在这里将其复杂度视为 O(1)。
     *
     * 空间复杂度：O(1)。
     *
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    /**
     *二分查找
     * 时间复杂度：O(log x)，即为二分查找需要的次数。
     *
     * 空间复杂度：O(1)。
     */
    public static int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     *牛顿迭代
     *
     * 时间复杂度：O(logx)，此方法是二次收敛的，相较于二分查找更快。
     *
     * 空间复杂度：O(1)。
     */
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
