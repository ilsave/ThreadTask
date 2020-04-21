package ru.gushin.ngtu.ivt.synhr0nized;

public class Main {
    private int counter;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.doWork();
    }

    public synchronized void inc(){
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    //counter = counter + 1;
                    inc();
                }
            }
        });


        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    //counter = counter + 1;
                    inc();
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println(counter);

    }



}
