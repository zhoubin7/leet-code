
/**
 * @Package: PACKAGE_NAME
 * @ClassName: PlusOne
 * @Description: 加一
 * @Author: pug
 * @Date: 2020/8/31 17:44
 * @Version: 1.0
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,8,9};
        int[] ints1 = plusOne1(digits);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }

    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
