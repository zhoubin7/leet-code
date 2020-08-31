/**
 * @Package: PACKAGE_NAME
 * @ClassName: LengthOfLastWord
 * @Description: 最后一个单词的长度
 * @Author: pug
 * @Date: 2020/8/31 17:03
 * @Version: 1.0
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1("Today is a nice day"));
        System.out.println(lengthOfLastWord1("a "));
        System.out.println(lengthOfLastWord1(" "));
    }
    public static int lengthOfLastWord(String s) {
        if(s.length() == 0){
            return 0;
        }
        String[] s1 = s.split(" ");
        if (s1.length == 0){
            return 0;
        }
        return s1[s1.length-1].length();
    }
    public static int lengthOfLastWord1(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = chars.length-1; i >=0 ; i--) {
            if (chars[i] == ' '){
                if (j==0){
                    continue;
                }
                break;
            }
            j++;
        }
        return j;
    }

    public static int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ')
            end--;
        if(end < 0)
            return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ')
            start--;
        return end - start;
    }

    public int lengthOfLastWord3(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count == 0)
                    continue;
                break;
            }
            count++;
        }
        return count;
    }

}
