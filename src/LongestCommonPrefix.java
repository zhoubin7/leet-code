/**
 * @Package: PACKAGE_NAME
 * @ClassName: LongestCommonPrefix
 * @Description: 最长公共前缀
 * @Author: pug
 * @Date: 2020/8/25 16:13
 * @Version: 1.0
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[]strs = {"flower","flow","flight"};
        /**
         * 二分查找：
         * 复杂度分析
         *
         * 时间复杂度：O(mn \log m)O(mnlogm)，其中 mm 是字符串数组中的字符串的最小长度，nn 是字符串的数量。二分查找的迭代执行次数是 O(\log m)O(logm)，
         * 每次迭代最多需要比较 mnmn 个字符，因此总时间复杂度是 O(mn \log m)O(mnlogm)。
         *
         * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
         *
         */
        System.out.println(longestCommonPrefix(strs));
        /**
         * 纵向扫描：
         * 复杂度分析
         *
         * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
         *
         * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
         *
         */
        System.out.println(longestCommonPrefix1(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
