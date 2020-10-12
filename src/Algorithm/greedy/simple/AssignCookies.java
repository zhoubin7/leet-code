package Algorithm.greedy.simple;

import java.util.Arrays;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: Algorithm.greedy.simple.AssignCookies
 * @Description: 分发饼干
 * @Author: pug
 * @Date: 2020/10/9 14:43
 * @Version: 1.0
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int contentChildren = findContentChildren1(g, s);
        System.out.println(contentChildren);
    }
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int k=s.length-1;
        for(int i=g.length-1;i>=0&&k>=0;i--){
            if(s[k]>=g[i]){
                k--;
            }
        }
        return s.length-1-k;
    }
}
