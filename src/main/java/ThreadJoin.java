/**
 * Created by pxc on 2018/6/12.
 */
public class ThreadJoin implements Runnable {
    static int i = 0;
    public static void main(String[] args) throws Exception {
        ThreadJoin r1 = new ThreadJoin();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("i等于 " + i);
    }
    @Override
    public void run() {
        addI(1000000);
    }
    public void addI(int j) {
        for (int k = 0; k < j; k++) {
            i++;
        }
    }
}
