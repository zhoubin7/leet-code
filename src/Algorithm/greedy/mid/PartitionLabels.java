package Algorithm.greedy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: Algorithm.greedy.mid
 * @ClassName: PartitionLabels
 * @Description: 763. 划分字母区间
 * @Author: pug
 * @Date: 2020/10/22 10:16
 * @Version: 1.0
 */
public class PartitionLabels {
    public static void main(String[] args) {
//        S = "ababcbacadefegdehijhklij"
        List<Integer> ababcbacadefegdehijhklij = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(ababcbacadefegdehijhklij);
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static List<Integer> partitionLabels1(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int len = S.length();

        // 做映射表，记录每个字母最后出现的位置
        int[] ma = new int[26];
        for (int i = 0; i < len; ++i) {
            ma[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        while (left < len) {
            char curLeft = S.charAt(left);
            // 最小右边界
            int right = ma[curLeft - 'a'];
            for (int i = left + 1; i < right; ++i) {
                // 枚举当前分段中的字符，更新右边界
                if (ma[S.charAt(i) - 'a'] > right) {
                    right = ma[S.charAt(i) - 'a'];
                }
            }
            // 至此，一个新的片段生成了
            ans.add(right - left + 1);
            // 分析下一段
            left = right + 1;
        }
        return ans;

    }
}
