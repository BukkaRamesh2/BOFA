package com.bofa.util;



/*
    Thread Class - basic
    Runnable Interface - More flexible approaches
    Callable and Future - Return Tasks from threads
    Executor Services - Thread pool Management
    CompletableFuture - Asynchronous Programming
    Parallel Streams - Parallel Processing
    ScheduledExecutorService - Scheduling Tasks

 */

    /*
    Lifecycle of a Thread
    1. New: Thread is created but not yet started. start()
    2. Runnable: Thread is ready to run and waiting for CPU time. run()
    3. Running: Thread is executing its task. status(), joins()
    4. Waiting: Thread is waiting for another thread to perform a task. sleep(), wait()
    5. Deadlock: Thread is blocked and cannot proceed.
     */

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class SimpleClientThread {

    // 1. Extending Thread Class
    static class MyThread extends Thread {
        public void run() {
            System.out.println("Thread Class: " + Thread.currentThread().getName() + " is running.");
        }
    }

    // 2. Implementing Runnable
    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Runnable: " + Thread.currentThread().getName() + " is running.");
        }
    }

    // 3. Implementing Callable
    static class MyCallable implements Callable<String> {
        public String call() {
            return "Callable executed by " + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. Using Thread Class
        MyThread thread1 = new MyThread();
        thread1.start();

        // 2. Using Runnable
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        // 3. Using Callable and Future
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new MyCallable());
        System.out.println(future.get()); // Blocks until callable returns a result

        // 4. Using ExecutorService (Thread Pool Management)
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            threadPool.execute(new MyRunnable());
        }
        threadPool.shutdown();

        // 5. Using CompletableFuture (Asynchronous Execution)
        CompletableFuture.supplyAsync(() -> "CompletableFuture Task")
                .thenApply(result -> result + " processed.")
                .thenAccept(System.out::println)
                .join();

        // 6. Using Parallel Streams
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.parallelStream().forEach(name ->
                System.out.println("Parallel Stream: " + Thread.currentThread().getName() + " - " + name));

        // 7. Using ScheduledExecutorService (Scheduled Execution)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Scheduled Task Executed!"), 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> System.out.println("Repeating Scheduled Task"), 1, 2, TimeUnit.SECONDS);

        // Shutdown executor after a delay
        Thread.sleep(8000);
        scheduler.shutdown();
        executor.shutdown();
    }
}
