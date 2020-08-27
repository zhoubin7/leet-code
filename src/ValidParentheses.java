import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: ValidParentheses
 * @Description: 有效的括号
 * @Author: pug
 * @Date: 2020/8/27 15:19
 * @Version: 1.0
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String str1 = "()[]{}";
        String str2 = "([)]";
        String str3 = "{[]}";
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
        System.out.println(isValid(str3));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
