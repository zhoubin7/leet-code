package Algorithm.greedy.mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Package: Algorithm.greedy.mid
 * @ClassName: RemoveDuplicateLetters
 * @Description: 316. 去除重复字母
 * @Author: pug
 * @Date: 2020/10/22 11:32
 * @Version: 1.0
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "bcabc";
        String s1 = removeDuplicateLetters2(s);
        System.out.println(s1);
    }

    public static String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static String removeDuplicateLetters1(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Integer> lo = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lo.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && lo.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static String removeDuplicateLetters2(String s) {
        int n = s.length(), c = 0, k = 0;
        int[] ss = new int[26];
        int[] es = new int[26];
        int[] ns = new int[n + 1];
        char[] t = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            int v = t[i] - 'a';
            ns[i + 1] = ss[v] == 0 ? n : ss[v];
            ss[v] = i + 1;
            if (es[v] == 0) {
                es[v] = i + 1;
                c++;
            }
        }
        char[] chars = new char[c];
        while (k < c) {
            for (int i = 0; i < 26; i++) {
                int si = ss[i];
                if (si == 0) continue;
                boolean flag = true;
                for (int j = i + 1; j < 26; j++) {
                    int ej = es[j];
                    if (ej == 0) continue;
                    if (si > ej) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    chars[k++] = (char) (i + 'a');
                    for (int l = 0; l < 26; l++) {
                        while (ss[l] != 0 && ss[l] < ss[i]) {
                            ss[l] = ns[ss[l]];
                        }
                    }
                    ss[i] = 0;
                    es[i] = 0;
                    break;
                }
            }
        }
        return new String(chars);
    }

}
