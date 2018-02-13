package com.iesvirgendelcarmen.hilos.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolHilos {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		int processors = runtime.availableProcessors();
		//System.out.println("Nº núcleos: " + processors);
		ExecutorService executor = Executors.newFixedThreadPool(2 + processors);
		for (int i = 0; i < 20; i++) {
			Runnable tarea = new HiloDelPool(i);
			executor.execute(tarea);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {}
		System.out.println("Terminado hilo principal");
	}

}

class HiloDelPool implements Runnable{
	
	private int atributo;
	
	

	public HiloDelPool(int atributo) {
	
		this.atributo = atributo;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inicio del hilo: " + Thread.currentThread().getName() 
				+ "--- atributo: " + atributo);
		try {
			Thread.sleep((long) (5_000 * Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("FIN del hilo: " + Thread.currentThread().getName() 
				+ "--- atributo: " + atributo);
		
	}
	
}