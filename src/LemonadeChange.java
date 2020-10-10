/**
 * @Package: PACKAGE_NAME
 * @ClassName: LemonadeChange
 * @Description: 柠檬水找零
 * @Author: pug
 * @Date: 2020/10/10 16:47
 * @Version: 1.0
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,20,20};
        boolean b = lemonadeChange(bills);
        System.out.println(b);
    }
    public static boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for (int bill : bills) {
            if (bill == 5){
                five++;
            }else if (bill == 10){
                if (five==0)return false;
                five--;
                ten++;
            }else {
                if (five>0&&ten>0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
