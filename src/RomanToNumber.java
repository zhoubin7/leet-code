import java.util.HashMap;
import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: RomanToNumber
 * @Description: 罗马数字转数字
 * @Author: pug
 * @Date: 2020/8/25 13:20
 * @Version: 1.0
 */
public class RomanToNumber {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIII"));
    }

    static Map<Character,Integer> hashMap = new HashMap<Character,Integer>(){{
        this.put('I',1);
        this.put('V',5);
        this.put('X',10);
        this.put('L',50);
        this.put('C',100);
        this.put('D',500);
        this.put('M',1000);
    }};

    public static int romanToInt(String s) {
        int sum = 0;
        Integer first = hashMap.get(s.charAt(0));
        for (int i = 1;i<s.length();i++){
            Integer temp = hashMap.get(s.charAt(i));
            if (first<temp){
                sum -= first;
            }else {
                sum += first;
            }
            first = temp;
        }
        sum += first;
        return sum;
    }
}
