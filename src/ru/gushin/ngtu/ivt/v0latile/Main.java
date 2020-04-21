package ru.gushin.ngtu.ivt.v0latile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();

    }
}
