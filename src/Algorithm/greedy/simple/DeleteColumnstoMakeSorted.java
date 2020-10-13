package Algorithm.greedy.simple;

/**
 * @Package: Algorithm.greedy.simple
 * @ClassName: DeleteColumnstoMakeSorted
 * @Description: 944. 删列造序
 * @Author: pug
 * @Date: 2020/10/12 11:20
 * @Version: 1.0
 */
public class DeleteColumnstoMakeSorted {
    public static void main(String[] args) {
//        ["cba", "daf", "ghi"]
        String[] str = {"cba", "daf", "ghi"};
        int i = minDeletionSize1(str);
        System.out.println(i);
    }

    public static int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r + 1].charAt(c)) {
                    ans++;
                    break;
                }
        return ans;
    }

    public static int minDeletionSize1(String[] A) {
        int result = 0;
        if (A.length == 0) return result;
        int len = A[0].length();
        for (int i = 0; i < len; i++) {
            result += help(A, i);
        }
        return result;
    }

    private static int help(String[] A, int i) {
        char last = A[0].charAt(i);
        for (int j = 1; j < A.length; j++) {
            char cur = A[j].charAt(i);
            if (cur < last) {
                return 1;
            }
            last = cur;
        }
        return 0;
    }
}
