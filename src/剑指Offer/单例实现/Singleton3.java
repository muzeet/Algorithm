package 剑指Offer.单例实现;

/**
 * 为什么需要2个if
 * 1. 第一个if为了提高效率，假如对象已经创建，则不用加锁，直接返回
 * 2. 假如第一个线程T1进入第一个if，此时还未获取锁，而资源时间用完被线程T2抢占，T2线程完成第一个if判断进入同步块，进入第二个if
 * 创建了单例对象，T2线程完成，T1线程抢占资源继续执行，进入同步块，进入第二个if直接返回，假如没有第二个if则会创建2个对象
 *
 * synchornized块中一定要有if判断，此方法相比Singleton2提高了效率，如果单例对象已被创建，则不用每次获取同步锁
 *
 *
 */
public class Singleton3 {
    private static volatile Singleton2 instance = null;


    public Singleton2 getInstance() {
        // 双重检查锁（DCL）
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
