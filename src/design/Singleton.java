package design;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/4/14 下午4:13
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){};

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
