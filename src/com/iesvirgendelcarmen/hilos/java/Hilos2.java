package com.iesvirgendelcarmen.hilos.java;

public class Hilos2 {

	public static void main(String[] args) {
		System.out.println("INICIO DEL PROGRAMA");
		Thread thread1 = new HiloNumeros(1000);
		thread1.start();
		Thread thread2 = new HiloNumeros(300);
		thread2.start();
		System.out.println("FIN DEL PROGRAMA");

	}

}
class HiloNumeros extends Thread {
	private int numero;
	
	public HiloNumeros(int numero) {
		this.numero = numero;
	}

	@Override
	public void run() {
		for (int i = 0; i < numero; i++) {
			try {
				Thread.sleep((long) (Math.random() * 500));
				System.out.println(Thread.currentThread().getName() + "  " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}