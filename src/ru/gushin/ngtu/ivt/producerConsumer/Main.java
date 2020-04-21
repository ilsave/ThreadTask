package ru.gushin.ngtu.ivt.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main {
private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        public static void main(String[] args) throws Exception {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    consumer();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    produce();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        }

        private static void produce() throws InterruptedException{
            Random random = new Random();

            while(true){
                queue.put(random.nextInt(100));
            }
        }

        private static void consumer() throws InterruptedException{
            Random random = new Random();
            while(true){
                Thread.sleep(100);
                if (random.nextInt(10) == 5){
                    System.out.println(queue.take());
                    System.out.println();
                    System.out.println("que size is " + queue.size());
                }
            }
        }

}
