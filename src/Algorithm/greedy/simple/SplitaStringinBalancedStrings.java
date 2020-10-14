package Algorithm.greedy.simple;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: SplitaStringinBalancedStrings
 * @Description: 1221. 分割平衡字符串
 * @Author: pug
 * @Date: 2020/10/14 11:43
 * @Version: 1.0
 */
public class SplitaStringinBalancedStrings {
    public static void main(String[] args) {
//        s = "RLRRLLRLRL"
        String s = "RLRRLLRLRL";
        int i = balancedStringSplit(s);
        System.out.println(i);
    }
    public static int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;
    }
}
