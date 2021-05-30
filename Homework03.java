package java0.conc0303;

import java.util.concurrent.*;

import static java0.conc0303.Homework03.Helper.printTaskResult;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException,BrokenBarrierException {

        // 1.FutureTask1
        long start=System.currentTimeMillis();
        FutureTask<Integer> task1 = new FutureTask<>(new ByCallable());
        new Thread(task1).start();
        printTaskResult(start, task1.get(), "FutureTask1");

        //2.FutureTask2
        start=System.currentTimeMillis();
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task2 = new FutureTask<>(new ByCallable());
        executor1.submit(task2);
        executor1.shutdown();
        printTaskResult(start, task2.get(), "FutureTask2");

        //3.Future
        start=System.currentTimeMillis();
        ExecutorService executor2 = Executors.newCachedThreadPool();
        Future<Integer> task3 = executor2.submit(new ByCallable());
        executor2.shutdown();
        printTaskResult(start, task3.get(), "Future");

        //4.CompletableFuture
        final long startTime =System.currentTimeMillis();
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> new ByCallable().call()).thenAccept(v -> printTaskResult(startTime, v, "CompletableFuture"));
        completableFuture.get();

        //5.ThreadLocal
        start=System.currentTimeMillis();
        Homework03 threadLocalMain = new Homework03();
        LocalThread client = new LocalThread(threadLocalMain,start);
        client.start();

        //6.CountDownLatch1
        start=System.currentTimeMillis();
        CountDownLatch latch1 = new CountDownLatch(1);
        new Thread(new ByThread(latch1,start)).start();
        latch1.await();

        //7.CountDownLatch2
        final long startTime1=System.currentTimeMillis();
        ExecutorService executor3 = Executors.newCachedThreadPool();
        CountDownLatch latch2 = new CountDownLatch(1);
        executor3.execute(() -> {
            try {
                printTaskResult(startTime1,sum(),"CountDownLatch2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch2.countDown();
            }
        });
        latch2.await();
        executor3.shutdown();

        //8.CyclicBarrier1
        final long startTime2=System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        new Thread(new ByCbThread(cyclicBarrier,startTime2)).start();

        //9.CyclicBarrier2
        final long startTime3=System.currentTimeMillis();
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(1);
        new Writer(cyclicBarrier2,startTime3).start();

        //10.Semaphore1
        start=System.currentTimeMillis();
        Semaphore semaphore = new Semaphore(1);
        new Worker(semaphore,start).start();

        //11.Semaphore2
        final long startTime4=System.currentTimeMillis();
        ExecutorService executor4 = Executors.newCachedThreadPool();
        final Semaphore semaphore2 = new Semaphore(1);
        executor4.execute(() -> {
            try {
                semaphore2.acquire(); // 获取全部许可，退化成串行执行
                int sum = sum();
                printTaskResult(startTime4,sum,"Semaphore2");
                semaphore2.release(); // 释放多个许可
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor4.shutdown();
    }

    public int getSum() {
        int sum = sum();
        return sum;
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    static class ByCallable implements Callable<Integer>{
        @Override
        public Integer call() {
            final int sum = sum();
            return sum;
        }
    }
    static class Helper {
        static void printTaskResult (long start, int result, String desc) {
            long doTime = System.currentTimeMillis()-start;
            System.out.printf("[方式：%s],异步计算结果为：%d,使用时间：%dms%n",desc,result,doTime);
        }
    }

    static class LocalThread extends Thread {
        private Homework03 homework03;
        private long start;

        public LocalThread(Homework03 homework03, long start) {
            this.homework03 = homework03;
            this.start = start;
        }

        public void run() {
            int sum = homework03.getSum();
            printTaskResult(start,sum,"ThreadLocal");
        }
    }
    static class ByThread implements Runnable {
        private CountDownLatch latch;
        private long startTime;
        public ByThread(CountDownLatch latch, long startTime){
            this.latch = latch;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            final int sum = sum();
            latch.countDown();
            printTaskResult(startTime, sum, "CountDownLatch1");
        }
    }

    static class ByCbThread implements Runnable {
        private CyclicBarrier cyc;
        private long startTime;
        public ByCbThread(CyclicBarrier cyc, long startTime){
            this.cyc = cyc;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    int sum = sum();
                    cyc.await();
                    printTaskResult(startTime, sum, "CyclicBarrier1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        private long startTime;
        public Writer(CyclicBarrier cyclicBarrier,long startTime) {
            this.cyclicBarrier = cyclicBarrier;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            try {
                int sum = sum();
                cyclicBarrier.await();
                printTaskResult(startTime, sum, "CyclicBarrier2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
        }
    }

    static class Worker extends Thread {
        private long startTime;
        private Semaphore semaphore;

        public Worker(Semaphore semaphore,long startTime) {
            this.startTime = startTime;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();  // 在子线程里控制资源占用
                int sum = sum();
                semaphore.release();   // 在子线程里控制释放资源占用
                printTaskResult(startTime, sum, "Semaphore1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
