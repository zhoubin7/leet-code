/**
 * @Package: PACKAGE_NAME
 * @ClassName: IsSubsequence
 * @Description: 判断子序列
 * @Author: pug
 * @Date: 2020/10/9 14:13
 * @Version: 1.0
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence2(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;

    }

    public static boolean isSubsequence3(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int p1 = 0, p2 = 0;
        while (p1 < charS.length && p2 < charT.length) {
            if (charS[p1] == charT[p2]) p1++;
            p2++;
        }
        return p1 == charS.length;
    }

    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index表示上一次查找的位置(第一次查找的时候为-1)，所以这里要从t的下标(index+1)开始查找
            index = t.indexOf(c, index + 1);
            //没找到，返回false
            if (index == -1)
                return false;
        }
        return true;
    }


    public static boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

}
