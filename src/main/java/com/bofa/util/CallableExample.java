package com.bofa.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CallableExample implements Callable<String>{

	public CallableExample() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Callable task executed by: " + Thread.currentThread().getName();
	}
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(3);  // effiecet execution
		
		Future<String> future =es.submit(new CallableExample());
		
		try {
			System.out.println("Result: "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		es.shutdown();
		
		
		ScheduledExecutorService ess = Executors.newScheduledThreadPool(3);  // effiecet execution

		ess.scheduleAtFixedRate(() -> {System.out.println("Scheduled task running.. " 
		+ Thread.currentThread().getName());}, 5, 3, TimeUnit.SECONDS);
		
		
		
	}

}
