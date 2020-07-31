/**
 * @Package: PACKAGE_NAME
 * @ClassName: PalindromicNumber
 * @Description: 回文数
 * @Author: pug
 * @Date: 2020/7/31 19:49
 * @Version: 1.0
 */
public class PalindromicNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(2578752));
        System.out.println(isPalindrome1(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if(x>=0 && x <10){
            return true;
        }
        if (x % 10 ==0){
            return false;
        }
        String str = x+"";
        char[] chars = str.toCharArray();
        StringBuffer sb =new StringBuffer();
        for (int i=chars.length-1;i>=0;i--) {
            sb.append(chars[i]);
        }
        return sb.toString().equals(str);
    }

    public static boolean isPalindrome1(int x) {
        if(x < 0) return false;
        if(x >= 0 && x < 10) return true;

        int reverse_x = 0;
        int temp_x = x;

        while(temp_x > 0) {
            reverse_x = reverse_x*10 + temp_x % 10;
            temp_x /= 10;
        }


        return reverse_x == x;

    }
}
