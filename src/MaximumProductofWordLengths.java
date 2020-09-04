import java.util.HashMap;
import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: MaximumProductofWordLengths
 * @Description: 最大单词长度乘积
 * @Author: pug
 * @Date: 2020/9/4 9:27
 * @Version: 1.0
 */
public class MaximumProductofWordLengths {
    public static void main(String[] args) {
        String[] str = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(str));
        System.out.println(maxProduct1(str));
        System.out.println(maxProduct2(str));
    }

    public static int maxProduct(String[] words) {
        int n = words.length;
        int maxProd = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (noCommonLetters(words[i], words[j]))
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
        return maxProd;
    }

    public static boolean noCommonLetters(String s1, String s2) {
        for (char ch : s1.toCharArray())
            if (s2.indexOf(ch) != -1) return false;
        return true;
    }

    public static int maxProduct1(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        int bitmask = 0;
        for (int i = 0; i < n; ++i) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                // add bit number bit_number in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            masks[i] = bitmask;
            lens[i] = words[i].length();
        }

        int maxVal = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if ((masks[i] & masks[j]) == 0)
                    maxVal = Math.max(maxVal, lens[i] * lens[j]);

        return maxVal;
    }

    //    public static boolean noCommonLetters1(String s1, String s2){
//        int bitmask1 = 0, bitmask2 = 0;
//        for (char ch : s1.toCharArray())
//            bitmask1 |= 1 << bitNumber(ch);
//        for (char ch : s2.toCharArray())
//            bitmask2 |= 1 << bitNumber(ch);
//
//        return (bitmask1 & bitmask2) == 0;
//    }
    public static int maxProduct2(String[] words) {
        Map<Integer, Integer> hashmap = new HashMap();

        int bitmask = 0, bitNum = 0;
        for (String word : words) {
            bitmask = 0;
            for (char ch : word.toCharArray()) {
                // add bit number bitNumber in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            // there could be different words with the same bitmask
            // ex. ab and aabb
            hashmap.put(bitmask, Math.max(hashmap.getOrDefault(bitmask, 0), word.length()));
        }

        int maxProd = 0;
        for (int x : hashmap.keySet())
            for (int y : hashmap.keySet())
                if ((x & y) == 0) maxProd = Math.max(maxProd, hashmap.get(x) * hashmap.get(y));

        return maxProd;
    }

    public static int bitNumber(char ch) {
        return (int) ch - (int) 'a';
    }

}
