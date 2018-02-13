package com.iesvirgendelcarmen.hilos.java;

public class CalculoSuma {

	public static void main(String[] args) {
		
		Suma hilo1 = new Suma(100_000_000);
		Suma hilo2 = new Suma(100_000_000);
		Suma hilo3 = new Suma(100_000_000);
		Suma hilo4 = new Suma(100_000_000);
		
		hilo1.start(); hilo2.start(); hilo3.start(); hilo4.start();
		try {
			hilo1.join(); hilo2.join(); hilo3.join(); hilo4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			Thread.sleep(20); //ARBITRARIO
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/   
		long suma1 = hilo1.getResultado();
		long suma2 = hilo2.getResultado();
		long suma3 = hilo3.getResultado();
		long suma4 = hilo4.getResultado();
		
		long resultado = suma1 + suma2 + suma3 + suma4;
		System.out.println("Resultado: " + resultado);


	}

}
class Suma extends Thread {
	private long valor;
	private long resultado = 0;
	
	public Suma(long valor) {
		super();
		this.valor = valor;
	}
	
	@Override
	public void run() {
		for (long i = 0; i < valor; i++) {
			resultado ++;
		}
	}

	public long getResultado() {
		return resultado;
	}
	
	
}




