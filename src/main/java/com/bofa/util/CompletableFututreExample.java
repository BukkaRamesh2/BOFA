package com.bofa.util;

import java.util.concurrent.CompletableFuture;

public class CompletableFututreExample {

	public CompletableFututreExample() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		CompletableFuture.supplyAsync( () -> {System.out.println(Thread.currentThread().getName() + "proceesing task .. ");
		return "Task Completed";}).thenAccept(result -> System.out.println("Result: " +result));
		
		System.out.println("Main Thrad continues execution....");
	}

}
