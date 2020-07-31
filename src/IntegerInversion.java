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
        int reverse = reverse(9646324351L);
        System.out.println(reverse);
    }

    public static int reverse(long x) {
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
}
