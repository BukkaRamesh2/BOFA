package com.bofa.util;


/*
 * 
 *   Thread class -- basic 
 *   Runnable Interface -- mpore flexible approaCH 
 *   Callable & Future --Retur resukts from thread
 *   ExecutorService -- Thread polling for efficeinet execution
 *   CompletableFututre -- Asynchronous 
 *   Prallel Stream -- 
 *   ScheduledExecutorService -- scheudukled Tasks
 *   
 *   
 *   
 *   LifeCycle
 *   -- new state  -- start()
 *   Runnable -- run() 
 *   Running  -- status(), joins()
 *   waiting -- sleep(), wait()
 *   Dead -- 
 *   
 *   
 *   
 *   Deadlock 
 *   
 *   
 *   in runnbale interface we need to creaet a thread object and psss your runnable intrface class to it.
 *   
 *   
 *   
 *   
 *   
 * 
 * 
 */

public class SimpleThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "is running simpe thread class");
		
	}
	
	public SimpleThread() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new SimpleThread());
		
	//	SimpleThread thread =  //
		thread.start(); // 
	}

}
