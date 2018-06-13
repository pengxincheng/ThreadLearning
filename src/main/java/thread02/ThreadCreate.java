package thread02;

import java.util.concurrent.*;

/**
 * Created by pxc on 2018/6/13.
 * 线程创建示例
 */
public class ThreadCreate {

    public static void main(String[] args) {
        //1.继承Thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread.start();
        //2.实现runable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现runable接口");
            }
        });
        thread1.start();
        //3.实现callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit((Callable) () -> "通过实现Callable接口");
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

   /*     ThreadDemo td = new ThreadDemo();
        // 1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
         FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();*/
        FutureTask<Integer> result = new FutureTask<>(() -> {
            Integer sum = 0;
            for (int i = 0; i <100 ; i++) {
                sum+=i;
            }
            return sum;
        });
        new Thread(result).start();
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
