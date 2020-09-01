/**
 * @Package: PACKAGE_NAME
 * @ClassName: AddBinary
 * @Description: 二进制求和
 * @Author: pug
 * @Date: 2020/8/31 18:24
 * @Version: 1.0
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("10101", "1011"));
        System.out.println(addBinary1("10101", "1011"));
        System.out.println(addBinary2("10101", "1011"));
    }

    /**
     * 如果字符串超过 3333 位，不能转化为 Integer
     * 如果字符串超过 6565 位，不能转化为 Long
     * 如果字符串超过 500000001500000001 位，不能转化为 BigInteger
     * 因此，为了适用于长度较大的字符串计算，我们应该使用更加健壮的算法。
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public static String addBinary1(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static String addBinary2(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        char[] s;
        char[] l;
        if (lenA <= lenB) {
            s = a.toCharArray();
            l = b.toCharArray();
        } else {
            s = b.toCharArray();
            l = a.toCharArray();
        }

        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '0') {
                continue;
            }
            if (s[i] == '1' && l[i + (l.length - s.length)] == '0') {
                l[i + (l.length - s.length)] = '1';
                continue;
            }
            //两者都为1
            l[i + (l.length - s.length)] = '0';
            boolean f = false;
            if (i - 1 + (l.length - s.length) < 0) {
                f = true;
            }
            for (int j = i - 1 + (l.length - s.length); j >= 0; j--) {
                if (l[j] == '1') {
                    l[j] = '0';
                    if (j == 0) {
                        f = true;
                    }
                } else {
                    l[j] = '1';
                    break;
                }
            }
            if (f) {
                char[] lNew = new char[l.length + 1];
                System.arraycopy(l, 0, lNew, 1, l.length);
                lNew[0] = '1';
                l = lNew;
            }
        }
        return new String(l);
    }

}
