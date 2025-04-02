package com.bofa.util;

import com.bofa.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class SampleEmployeeThread {
    // Runnable Implementation
    static class EmployeeRunnable implements Runnable {
        private final Employee employee;

        public EmployeeRunnable(Employee employee) {
            this.employee = employee;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Processing Employee (Runnable): " + employee.getFirstName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + "Finished Processing (Runnable): " + employee.getFirstName());
        }
    }

    // Callable Implementation
    static class EmployeeCallable implements Callable<String> {
        private final Employee employee;

        public EmployeeCallable(Employee employee) {
            this.employee = employee;
        }

        @Override
        public String call() {
            System.out.println(Thread.currentThread().getName() + " Processing Employee (Callable): " + employee.getFirstName());
            try {
                Thread.sleep(1000); // Simulating a time-consuming task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return Thread.currentThread().getName() + " Finished Processing (Callable): " + employee.getFirstName();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Creating sample employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "kiran", "kumar", "123 St", "kiran@example.com", 1234567890L, "Male", 50000),
                new Employee(2, "sai", "reddy", "456 Ave", "sai@example.com", 9876543210L, "Male", 60000),
                new Employee(3, "krishna", "kanth", "789 Blvd", "krishna@example.com", 1122334455L, "Male", 55000)
        );

        // Executor Service with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Running tasks using Runnable
        for (Employee emp : employees) {
            executorService.execute(new EmployeeRunnable(emp));
        }

        // Running tasks using Callable and collecting results
        List<Future<String>> futureResults = employees.stream()
                .map(emp -> executorService.submit(new EmployeeCallable(emp)))
                .collect(Collectors.toList());

        // Fetching results from Callable tasks
        for (Future<String> future : futureResults) {
            System.out.println(future.get()); // This blocks until the task is done
        }

        // Asynchronous Execution using CompletableFuture
        employees.forEach(emp ->
                CompletableFuture.supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName() + " Processing Employee (CompletableFuture): " + emp.getFirstName());
                            return "Processed " + emp.getFirstName();
                        }).thenApply(result -> result + " Successfully Completed")
                        .thenAccept(System.out::println)
        );

        // Using Parallel Streams
        employees.parallelStream().forEach(emp ->
                System.out.println(Thread.currentThread().getName() + "Parallel Stream Processing: " + emp.getFirstName())
        );

        // Using ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("\nScheduled Task Executed!"), 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> System.out.println("Repeating Scheduled Task"), 1, 2, TimeUnit.SECONDS);

        // Shutdown executors
        Thread.sleep(8000);
        scheduler.shutdown();
        executorService.shutdown();
    }
}
