/**
 * @Package: PACKAGE_NAME
 * @ClassName: IntegerInversion
 * @Description: 整数反转
 * @Author: pug
 * @Date: 2020/7/10 16:12
 * @Version: 1.0
 */
public class IntegerInversion {

    public static void main(String[] args) {
        int reverse = reverse(96463243);
        int reverse1 = reverse1(96463243);
        System.out.println(reverse);
        System.out.println(reverse1);
    }

    public static int reverse(int x) {
        String s = x+"";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=chars.length-1;i > -1 ;i--){
            sb.append(chars[i]);
        }
        if (x >= 0){
            return Integer.parseInt(sb.toString());
        }else {
            return - Integer.parseInt(sb.toString().replace("-",""));
        }
    }

    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
