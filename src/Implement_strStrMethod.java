/**
 * @Package: PACKAGE_NAME
 * @ClassName: Implement_strStrMethod
 * @Description: 实现 strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @Author: pug
 * @Date: 2020/8/28 15:17
 * @Version: 1.0
 */
public class Implement_strStrMethod {
    public static void main(String[] args) {
//        System.out.println(strStr("hello","ll"));
        System.out.println(strStr1("hello my son"," s"));
        System.out.println(strStr2("oh my god,holy shit!",",h"));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 滑动窗口比较
     */
    public static int strStr1(String s1, String s2) {
        int t = s2.length(), s = s1.length();
        for (int start = 0; start < s - t + 1; ++start) {
            if (s1.substring(start, start + t).equals(s2)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 双指针
     */
    public static int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // 找到needle第一个字符在haystack中出现的位置
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }


    /**
     * Rabin Karp - 常数复杂度
     */
    public int strStr3(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
//        long modulus = (long)Math.pow(2, 31);
        long modulus = (long) 2 << 30;

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }
}
