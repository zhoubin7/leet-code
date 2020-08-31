package thread;

/**
 * @Package: thread
 * @ClassName: T3
 * @Description: 线程stop强制性中止，破坏线程安全的示例
 * @Author: pug
 * @Date: 2020/8/31 14:02
 * @Version: 1.0
 */
public class T3 {
    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        // 休眠1秒，确保i变量自增成功
        Thread.sleep(1000);
        // 暂停线程
//        thread.stop(); // 错误的终止
         thread.interrupt(); // 正确终止
        while (thread.isAlive()) {
            // 确保线程已经终止
        } // 输出结果
        thread.print();
    }
}
