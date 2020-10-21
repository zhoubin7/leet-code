import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Package: PACKAGE_NAME
 * @ClassName: MyTest
 * @Description:
 * @Author: pug
 * @Date: 2020/8/28 16:03
 * @Version: 1.0
 */
public class MyTest {

    public static void main(String[] args) {
        a:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j==1){
                    break a;
                }
                System.out.println("i:"+i+",j:"+j);
            }
        }
    }
}
