package Dialogue;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        var currentThread = Thread.currentThread();
        int i = 0;
        while (i != 5){
            Thread.sleep(1500);
           System.out.println("Я поток " + currentThread.getName() + " Всем привет!");
            i++;
        }
        System.out.println(i);
        return i;
    }
}
