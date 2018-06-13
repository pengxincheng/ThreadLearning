package thread01;

/**
 * Created by pxc on 2018/6/13.
 */
public class DeadLockDemo {
    private static String resourceA = "A";
    private static String resourceB = "B";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + "get resourceA");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "wait resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + "get resourceB");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println(Thread.currentThread().getName() + "get resourceB");

                System.out.println(Thread.currentThread().getName() + "wait resourceA");
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "get resourceA");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
