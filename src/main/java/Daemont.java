/**
 * Created by pxc on 2018/6/12.
 */
public class Daemont {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           while (true){
               System.out.println("Hello");
           }
        });
        Thread t2 = new Thread(()->{
            while (true){
                System.out.println("守护线程");
            }
        });
        t2.setDaemon(true);
        t1.start();  //不启动T1是t2也并不会运行
        t2.start();

        t1.setPriority(Thread.MAX_PRIORITY); //最高优先级
        t1.setPriority(Thread.MIN_PRIORITY); //最低优先级
        t1.setPriority(Thread.NORM_PRIORITY); //一般优先级


    }

}
