import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: StringAdd
 * @Description: 字符串相加
 * @Author: pug
 * @Date: 2020/8/3 10:01
 * @Version: 1.0
 */
public class StringAdd {

    public static void main(String[] args) {
        String num1 = "1489";
        String num2 = "24";
        System.out.println(addStrings(num1,num2));;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            //num1.charAt(i)对应的ASCII 48-57  0:48
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
