package Dialogue;

public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Я поток " + getName() + " Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("Поток %s завершен\n", getName());
        }
        if(isInterrupted())return;
    }
}
