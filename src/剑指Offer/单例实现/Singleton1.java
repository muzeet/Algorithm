package 剑指Offer.单例实现;

/**
 * 多线程下不能满足单例
 */
public class Singleton1 {

    // volatile 关键字是保证变量在多线程运行时可见性
    private static volatile Singleton1 instance = null;

    public Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }


}
