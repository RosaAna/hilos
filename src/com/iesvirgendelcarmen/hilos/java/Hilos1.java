package com.iesvirgendelcarmen.hilos.java;

public class Hilos1 {

	public static void main(String[] args) {
		Thread hiloUno = new HiloUno();
		hiloUno.start();
		Thread hiloDos = new Thread(new HiloDos());
		hiloDos.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10_000; i++) {
					try {
						Thread.sleep((long) (Math.random() * 2_000));
						System.out.println("EJECUCIÓN EN HILO 3");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		for (int i = 0; i < 10_000; i++) {
			try {
				Thread.sleep((long) (Math.random() * 2_000));
				System.out.println("EJECUCIÓN EN HILO PRINCIPAL");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
class HiloUno extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			try {
				Thread.sleep((long) (Math.random() * 2_000));
				System.out.println("ejecución en hilo UNO");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class HiloDos implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10_000; i++) {
			try {
				Thread.sleep((long) (Math.random() * 2_000));
				System.out.println("EJECUCIÓN en hilo dos");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}





