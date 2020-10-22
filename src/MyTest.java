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
        System.out.println("-----------开始推送--------------");
        long stime = System.currentTimeMillis();


        for (int i = 0; i < 100; i++) {
            //通过ThreadPoolTaskExecutor.excute执行一个业务方法
            //看日志的情况这100个线程其实执行的很慢：可能10秒钟
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("订阅推送任务耗时："+ (endTime - stime) +"ms");
        //这个耗时打印出来可能就5ms
//        a:
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (j==1){
//                    break a;
//                }
//                System.out.println("i:"+i+",j:"+j);
//            }
//        }
    }
}
