/**
 * Created by pxc on 2018/6/11.
 */
public class ThreadInterrupt2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
           while (true){
               if(Thread.currentThread().isInterrupted()){
                   System.out.println("线程中断！结束循环");
                   break;
               }else {
                   System.out.println(" 线程执行");
                   Thread.yield();
               }
           }
        });
  /*      t.start();
        Thread.sleep(1000L);
        t.interrupt();*/

        Thread t2 = new Thread(()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){  // 判断是否被中断，并清除当前中断状态
                    System.out.println("线程中断！结束循环");
                    break;
                }
                System.out.println("线程执行");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                  //  Thread.currentThread().interrupt();
                    //设置中断状态，抛出异常后会清除中断标记位
                    e.printStackTrace();
                }
                Thread.yield();
            }
        });
        t2.start();
        Thread.sleep(1000L);
        t2.interrupt();

    }
}
