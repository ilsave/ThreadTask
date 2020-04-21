package ru.gushin.ngtu.ivt.v0latile;

public class MyThread extends Thread {
    private volatile boolean running = true;

    public void run(){
        int i = 0;
        while (running){
            i ++;
            System.out.println("Hey there!");
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        this.running = false;
    }

}
