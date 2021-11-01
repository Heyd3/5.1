package Dialogue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        MyThread mt1 = new MyThread();
//        MyThread mt2 = new MyThread();
//        MyThread mt3 = new MyThread();
//        MyThread mt4 = new MyThread();
//        mt1.setName("1");
//        mt2.setName("2");
//        mt3.setName("3");
//        mt4.setName("4");
//
//        ThreadGroup mainGroup =new ThreadGroup("main group");
//        final Thread thread1 =new Thread(mainGroup, mt1);
//        final Thread thread2 =new Thread(mainGroup, mt2);
//        final Thread thread3 =new Thread(mainGroup, mt3);
//        final Thread thread4 =new Thread(mainGroup, mt4);
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        Thread.sleep(15000);
//        mainGroup.interrupt();

        Callable<Integer> myCallable1 = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        Callable<Integer> myCallable4 = new MyCallable();

        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(myCallable1);
        tasks.add(myCallable2);
        tasks.add(myCallable3);
        tasks.add(myCallable4);

        List<Future<Integer>> invokeAll = threadPool.invokeAll(tasks);
//        Integer invokeAny = threadPool.invokeAny(tasks);
//        System.out.println(invokeAny);


        for (Future<Integer> fut : invokeAll) {
            try {
                System.out.println(new Date() + "::" + "Выполнено " + fut.get() + " операций");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();

    }
}
