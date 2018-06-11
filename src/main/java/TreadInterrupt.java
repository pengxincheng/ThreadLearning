/**
 * Created by pxc on 2018/6/11.
 */
public class TreadInterrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true){
                Thread.yield();
            }
        });
        t.start();
        t.interrupt();
    }
}
