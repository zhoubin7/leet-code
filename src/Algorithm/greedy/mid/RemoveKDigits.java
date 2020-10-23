package Algorithm.greedy.mid;

import java.util.LinkedList;

/**
 * @Package: Algorithm.greedy.mid
 * @ClassName: RemoveKDigits
 * @Description: 402. 移掉K位数字
 * @Author: pug
 * @Date: 2020/10/23 9:54
 * @Version: 1.0
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String s = removeKdigits(num, k);
        System.out.println(s);
    }
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) return "0";
        return ret.toString();

    }
}
