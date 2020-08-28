/**
 * @Package: PACKAGE_NAME
 * @ClassName: RobotReturnToOrigin
 * @Description: 机器人能否返回原点
 * @Author: pug
 * @Date: 2020/8/28 11:00
 * @Version: 1.0
 */
public class RobotReturnToOrigin {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }

    private static boolean judgeCircle(String moves) {
        int x = 0,y=0,lt=moves.length();
        for (int i=0;i<lt;i++){
            char c = moves.charAt(i);
            if (c == 'L'){
                x--;
            }else if(c == 'R'){
                x++;
            }else if(c == 'U'){
                y++;
            }else if(c == 'D'){
                y--;
            }
        }
        return x==0 && y==0;
    }
}
