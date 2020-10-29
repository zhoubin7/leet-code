package study;

/**
 * @Package: study
 * @ClassName: Singleton
 * @Description: TODO(用一句话描述该文件做什么)
 * @Author: pug
 * @Date: 2020/10/16 9:50
 * @Version: 1.0
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getUniqueInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
