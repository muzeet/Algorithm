package 剑指Offer.单例实现;

/**
 *
 * 加锁的形式可以解决多线程问题，但是效率不高
 *
 */
public class Singleton2 {

    private static volatile Singleton2 instance = null;

    public synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
